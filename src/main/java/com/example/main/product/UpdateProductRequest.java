package com.example.main.product;

import org.springframework.util.Assert;

public record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
	public UpdateProductRequest {
		Assert.hasText(name, "name must be declared");
		Assert.isTrue(price > 0, "price must be over 0");
		Assert.notNull(discountPolicy, "discount policy required");
	}
}
