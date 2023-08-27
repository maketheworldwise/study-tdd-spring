package com.example.main.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

	private PaymentService paymentService;
	private PaymentPort paymentPort;

	@BeforeEach
	void setUp() {
		PaymentGateway paymentGateway = new ConsolePaymentGateway();
		PaymentRepository paymentRepository = new PaymentRepository();
		paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
		paymentService = new PaymentService(paymentPort);
	}

	@Test
	void paymentOrder() {
		final PaymentRequest request = PaymentSteps.getAddPaymentRequest();

		paymentService.payment(request);
	}
}
