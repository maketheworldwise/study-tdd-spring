package com.example.main.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void update() {
		final Product product = new Product("product", 1000, DiscountPolicy.NONE);
		product.update("modify", 2000, DiscountPolicy.NONE);

		assertThat(product.getName()).isEqualTo("modify");
		assertThat(product.getPrice()).isEqualTo(2000);
	}
}