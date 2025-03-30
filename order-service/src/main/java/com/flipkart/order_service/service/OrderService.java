package com.flipkart.order_service.service;

import com.flipkart.order_service.dto.InventoryResponseDto;
import com.flipkart.order_service.dto.OrderRequest;
import com.flipkart.order_service.entities.Orders;
import com.flipkart.order_service.entities.OrderItem;
import com.flipkart.order_service.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private WebClient webClient;


    public String placeOrder(OrderRequest orderRequest){
        Orders order=new Orders();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderItem> orderItems = orderRequest
                .getOrderItemDtoList()
                .stream()
                .map(OrderItemDto -> modelMapper.map(OrderItemDto, OrderItem.class)).toList();

        order.setOrderItemsList(orderItems);

        List<String> skuCodes = order.getOrderItemsList().stream().map(OrderItem::getSkuCode).toList();
        //call inventory microservice
        InventoryResponseDto[] result = webClient
                .get()
                .uri("http://localhost:9092/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponseDto[].class)
                .block();

        boolean allProductInStock = Arrays.stream(result).allMatch(InventoryResponseDto::isProductInStock);

        if (allProductInStock)
        {
            orderRepository.save(order);
            return "Order placed successfully";
        }
        else {
            throw new IllegalArgumentException("Product is not in stock,Please try again later");
        }
    }

}
