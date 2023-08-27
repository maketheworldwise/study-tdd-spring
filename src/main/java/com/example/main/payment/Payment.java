package com.example.main.payment;

import org.springframework.util.Assert;

import com.example.main.order.Order;

public class Payment {
	private Long id;
	private final Order order;
	private final String cardNumber;

	public Payment(Order order, String cardNumber) {
		Assert.notNull(order, "order must be required");
		Assert.hasText(cardNumber, "cardNumber must have text");
		this.order = order;
		this.cardNumber = cardNumber;
	}

	public void assignId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public int getPrice() {
		return order.getTotalPrice();
	}

	public String getCardNumber() {
		return this.cardNumber;
	}
}
