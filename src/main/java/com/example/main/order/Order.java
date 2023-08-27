package com.example.main.order;

import org.springframework.util.Assert;

import com.example.main.product.Product;

class Order {
	private Long id;
	private final Product product;
	private final int quantity;

	public Order(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		Assert.notNull(product, "product must be required");
		Assert.isTrue(quantity > 0, "quantity must be over 0");
	}

	public void assignId(Long aLong) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
}
