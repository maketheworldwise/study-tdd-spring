package com.example.product;

import org.springframework.util.Assert;

class Product {
	private final String name;
	private final int price;
	private final DiscountPolicy discountPolicy;
	private Long id;

	public Product(String name, int price, DiscountPolicy discountPolicy) {
		Assert.hasText(name, "name must be declared");
		Assert.isTrue(price > 0, "price must be over 0");
		Assert.notNull(discountPolicy, "discount policy required");
		this.name = name;
		this.price = price;
		this.discountPolicy = discountPolicy;
	}

	public void assignId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
