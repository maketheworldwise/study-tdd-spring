package com.example.main.product.application.service;

import org.springframework.util.Assert;

import com.example.main.product.domain.DiscountPolicy;

public record GetProductResponse(Long id, String name, int price, DiscountPolicy discountPolicy) {

	public GetProductResponse {
		Assert.notNull(id, "id must be declared");
		Assert.hasText(name, "name must be declared");
		Assert.notNull(discountPolicy, "discount policy required");
	}
}
