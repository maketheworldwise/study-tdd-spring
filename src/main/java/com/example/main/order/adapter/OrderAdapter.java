package com.example.main.order.adapter;

import org.springframework.stereotype.Component;

import com.example.main.order.application.port.OrderPort;
import com.example.main.order.domain.Order;
import com.example.main.product.domain.Product;
import com.example.main.product.adapter.ProductRepository;

@Component
class OrderAdapter implements OrderPort {
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;

	public OrderAdapter(final ProductRepository productRepository, final OrderRepository orderRepository) {
		this.productRepository = productRepository;
		this.orderRepository = orderRepository;
	}

	@Override
	public Product getProductById(Long productId) {
		return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("No product"));
	}

	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}
}
