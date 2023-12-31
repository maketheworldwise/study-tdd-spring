package com.example.main.payment.application.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.order.domain.Order;
import com.example.main.payment.application.port.PaymentPort;
import com.example.main.payment.domain.Payment;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/payments")
public class PaymentService {

	private final PaymentPort paymentPort;

	public PaymentService(PaymentPort paymentPort) {
		this.paymentPort = paymentPort;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> payment(@RequestBody PaymentRequest request) {
		Order order = paymentPort.getOrder(request.orderId());

		final Payment payment = new Payment(order, request.cardNumber());

		paymentPort.pay(payment.getPrice(), payment.getCardNumber());
		paymentPort.save(payment);


		return ResponseEntity.ok().build();
	}
}
