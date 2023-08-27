package com.example.main.payment;

interface PaymentGateway {
	void execute(int totalPrice, String cardNumber);
}
