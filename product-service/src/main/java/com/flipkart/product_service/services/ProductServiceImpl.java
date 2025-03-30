package com.flipkart.product_service.services;

import com.flipkart.product_service.dto.ProductRequest;
import com.flipkart.product_service.dto.ProductResponse;
import com.flipkart.product_service.entities.Product;
import com.flipkart.product_service.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    public void createProduct(ProductRequest productRequest)
    {
        Product product=modelMapper.map(productRequest, Product.class);
        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductResponse.class)).collect(Collectors.toList());
    }
}
