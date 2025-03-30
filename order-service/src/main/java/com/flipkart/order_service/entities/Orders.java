package com.flipkart.order_service.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String OrderNumber;

    @OneToMany(cascade=CascadeType.ALL)
    private List<OrderItem>orderItemsList;

    public Orders(String orderNumber, List<OrderItem> orderItemsList) {
        OrderNumber = orderNumber;
        this.orderItemsList = orderItemsList;
    }
    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public List<OrderItem> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItem> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }
}
