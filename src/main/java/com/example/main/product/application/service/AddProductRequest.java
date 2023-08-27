package com.example.main.product.application.service;

import org.springframework.util.Assert;

import com.example.main.product.domain.DiscountPolicy;

public record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
	public AddProductRequest {
		Assert.hasText(name, "name must be declared");
		Assert.isTrue(price > 0, "price must be over 0");
		Assert.notNull(discountPolicy, "discount policy required");
	}
}
