package com.example.main.order.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.order.application.port.OrderPort;
import com.example.main.order.domain.Order;
import com.example.main.product.domain.Product;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/orders")
public
class OrderService {

	private final OrderPort orderPort;

	public OrderService(final OrderPort orderPort) {
		this.orderPort = orderPort;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest request) {
		final Product product = orderPort.getProductById(request.productId());

		final Order order = new Order(product, request.quantity());
		orderPort.save(order);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
