package com.example.main.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.main.order.domain.Order;
import com.example.main.product.domain.DiscountPolicy;
import com.example.main.product.domain.Product;

class OrderTest {

	@Test
	void getTotalPrice() {
		final Order order = new Order(new Product("product", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);

		final int totalPrice = order.getTotalPrice();

		assertThat(totalPrice).isEqualTo(2000);
	}

}