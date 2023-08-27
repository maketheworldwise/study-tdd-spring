package com.example.main.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.main.product.domain.DiscountPolicy;
import com.example.main.product.domain.Product;

class ProductTest {

	@Test
	void update() {
		final Product product = new Product("product", 1000, DiscountPolicy.NONE);
		product.update("modify", 2000, DiscountPolicy.NONE);

		assertThat(product.getName()).isEqualTo("modify");
		assertThat(product.getPrice()).isEqualTo(2000);
	}

	@Test
	void noneDiscountedProduct() {
		final Product product = new Product("product", 1000, DiscountPolicy.NONE);

		final int discountedPrice = product.getDiscountedPrice();

		assertThat(discountedPrice).isEqualTo(1000);
	}

	@Test
	void fix1000DiscountedProduct() {
		final Product product = new Product("product", 1000, DiscountPolicy.NONE);

		final int discountedPrice = product.getDiscountedPrice();

		assertThat(discountedPrice).isEqualTo(0);
	}
}