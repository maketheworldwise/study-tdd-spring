package com.example.main.order;

import org.springframework.stereotype.Component;

import com.example.main.product.Product;

@Component
class OrderService {

	private final OrderPort orderPort;

	public OrderService(final OrderPort orderPort) {
		this.orderPort = orderPort;
	}

	public void createOrder(CreateOrderRequest request) {
		final Product product = orderPort.getProductById(request.productId());

		final Order order = new Order(product, request.quantity());
		orderPort.save(order);
	}
}
