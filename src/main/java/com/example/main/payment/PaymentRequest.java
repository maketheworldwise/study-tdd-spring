package com.example.main.payment;

import org.springframework.util.Assert;

record PaymentRequest(Long orderId, String cardNumber) {
	PaymentRequest(Long orderId, String cardNumber) {
		this.orderId = orderId;
		this.cardNumber = cardNumber;
		Assert.notNull(orderId, "orderId must be required");
		Assert.hasText(cardNumber, "cardNumber must have text");
	}
}
