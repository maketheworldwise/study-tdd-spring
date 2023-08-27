package com.example.main.payment.application.service;

import org.springframework.util.Assert;

public record PaymentRequest(Long orderId, String cardNumber) {
	public PaymentRequest(Long orderId, String cardNumber) {
		this.orderId = orderId;
		this.cardNumber = cardNumber;
		Assert.notNull(orderId, "orderId must be required");
		Assert.hasText(cardNumber, "cardNumber must have text");
	}
}
