package com.example.main.order;

import com.example.main.product.Product;

class OrderService {

	private OrderPort orderPort;

	public OrderService(final OrderPort orderPort) {
		this.orderPort = orderPort;
	}

	public void createOrder(CreateOrderRequest request) {
		final Product product = orderPort.getProductById(request.productId());

		final Order order = new Order(product, request.quantity());
		orderPort.save(order);
	}
}
