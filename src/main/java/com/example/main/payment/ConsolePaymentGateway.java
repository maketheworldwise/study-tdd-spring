package com.example.main.payment;

public class ConsolePaymentGateway implements PaymentGateway {
	@Override
	public void execute(int totalPrice, String cardNumber) {
		System.out.println("price: " + totalPrice);
		System.out.println("cardNumber: " + cardNumber);
		System.out.println("paid");
	}
}
