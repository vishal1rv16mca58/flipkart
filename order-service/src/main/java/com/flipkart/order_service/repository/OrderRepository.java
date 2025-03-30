package com.flipkart.order_service.repository;

import com.flipkart.order_service.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
