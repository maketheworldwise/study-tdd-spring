package com.example.main.product;

import org.springframework.util.Assert;

public record GetProductResponse(Long id, String name, int price, DiscountPolicy discountPolicy) {

	public GetProductResponse {
		Assert.notNull(id, "id must be declared");
		Assert.hasText(name, "name must be declared");
		Assert.notNull(discountPolicy, "discount policy required");
	}
}
