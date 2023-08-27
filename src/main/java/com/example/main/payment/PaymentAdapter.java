package com.example.main.payment;

import org.springframework.stereotype.Component;

import com.example.main.order.Order;
import com.example.main.order.OrderRepository;

@Component
class PaymentAdapter implements PaymentPort {
	private final PaymentGateway paymentGateway;
	private final PaymentRepository paymentRepository;
	private final OrderRepository orderRepository;

	public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository,
		OrderRepository orderRepository) {
		this.paymentGateway = paymentGateway;
		this.paymentRepository = paymentRepository;
		this.orderRepository = orderRepository;
	}

	@Override
	public Order getOrder(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("order not found"));
	}

	@Override
	public void pay(int totalPrice, String cardNumber) {
		paymentGateway.execute(totalPrice, cardNumber);
	}

	@Override
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}
}
