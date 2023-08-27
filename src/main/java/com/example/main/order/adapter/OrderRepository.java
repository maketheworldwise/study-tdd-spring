package com.example.main.order.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
