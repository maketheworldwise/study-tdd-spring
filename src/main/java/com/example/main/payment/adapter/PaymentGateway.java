package com.example.main.payment.adapter;

interface PaymentGateway {
	void execute(int totalPrice, String cardNumber);
}
