package com.example.main.payment;

public class PaymentSteps {
	static PaymentRequest getAddPaymentRequest() {
		final Long orderId = 1L;
		final String cardNumber = "1234-1234-1234-1234";
		return new PaymentRequest(orderId, cardNumber);
	}
}
