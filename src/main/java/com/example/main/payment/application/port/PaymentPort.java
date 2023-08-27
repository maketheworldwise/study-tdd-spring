package com.example.main.payment.application.port;

import com.example.main.order.domain.Order;
import com.example.main.payment.domain.Payment;

public interface PaymentPort {
	Order getOrder(Long orderId);

	void pay(int price, String cardNumber);

	void save(Payment payment);
}
