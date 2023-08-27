package com.example.main.payment;

import com.example.main.order.Order;
import com.example.main.product.DiscountPolicy;
import com.example.main.product.Product;

class PaymentAdapter implements PaymentPort {
	private final PaymentGateway paymentGateway;
	private final PaymentRepository paymentRepository;

	public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
		this.paymentGateway = paymentGateway;
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Order getOrder(Long orderId) {
		return new Order(new Product("product", 1000, DiscountPolicy.NONE), 2);

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
