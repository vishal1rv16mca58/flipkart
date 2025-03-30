package com.flipkart.order_service.dto;

import java.util.List;

public class OrderRequest {

    private List<OrderItemDto> orderItemDtoList;

    public OrderRequest(List<OrderItemDto> orderItemDtoList) {
        this.orderItemDtoList = orderItemDtoList;
    }

    public OrderRequest() {
    }

    public List<OrderItemDto> getOrderItemDtoList() {
        return orderItemDtoList;
    }

    public void setOrderItemDtoList(List<OrderItemDto> orderItemDtoList) {
        this.orderItemDtoList = orderItemDtoList;
    }
}
