package com.example.main.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiscountPolicyTest {
	@Test
	void noneDiscountPolicy() {
		final int price = 1000;
		final int discountedPrice = DiscountPolicy.NONE.applyDiscount(price);

		assertThat(discountedPrice).isEqualTo(price);
	}

	@Test
	void fixDiscountPolicy() {
		final int price = 2000;
		final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

		assertThat(discountedPrice).isEqualTo(1000);
	}

	@Test
	void overDiscountedPrice() {
		final int price = 500;
		final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

		assertThat(discountedPrice).isEqualTo(0);
	}
}