package com.example.main.order;

import org.springframework.stereotype.Component;

import com.example.main.product.Product;
import com.example.main.product.ProductRepository;

@Component
class OrderAdapter implements OrderPort {
	private final ProductRepository productRepository;
	private OrderRepository orderRepository;

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
