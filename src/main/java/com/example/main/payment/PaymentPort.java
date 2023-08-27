package com.example.main.payment;

import com.example.main.order.Order;

interface PaymentPort {
	Order getOrder(Long orderId);

	void pay(int price, String cardNumber);

	void save(Payment payment);
}
