package com.example.main.order.application.service;

import org.springframework.util.Assert;

public record CreateOrderRequest(Long productId, int quantity) {
	public CreateOrderRequest {
		Assert.notNull(productId, "productId must be required");
		Assert.isTrue(quantity > 0, "quantity must be over 0");
	}
}
