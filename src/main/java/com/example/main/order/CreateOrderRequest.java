package com.example.main.order;

import org.springframework.util.Assert;

record CreateOrderRequest(Long productId, int quantity) {
	CreateOrderRequest {
		Assert.notNull(productId, "productId must be required");
		Assert.isTrue(quantity > 0, "quantity must be over 0");
	}
}
