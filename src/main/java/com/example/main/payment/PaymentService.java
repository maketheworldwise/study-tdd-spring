package com.example.main.payment;

import com.example.main.order.Order;

class PaymentService {

	private final PaymentPort paymentPort;

	public PaymentService(PaymentPort paymentPort) {
		this.paymentPort = paymentPort;
	}

	public void payment(PaymentRequest request) {
		Order order = paymentPort.getOrder(request.orderId());

		final Payment payment = new Payment(order, request.cardNumber());

		paymentPort.pay(payment.getPrice(), payment.getCardNumber());
		paymentPort.save(payment);
	}
}
