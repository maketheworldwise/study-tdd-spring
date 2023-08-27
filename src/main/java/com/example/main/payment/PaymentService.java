package com.example.main.payment;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.order.Order;

@RestController
@RequestMapping("/payments")
public class PaymentService {

	private final PaymentPort paymentPort;

	public PaymentService(PaymentPort paymentPort) {
		this.paymentPort = paymentPort;
	}

	@PostMapping
	public ResponseEntity<Void> payment(@RequestBody PaymentRequest request) {
		Order order = paymentPort.getOrder(request.orderId());

		final Payment payment = new Payment(order, request.cardNumber());

		paymentPort.pay(payment.getPrice(), payment.getCardNumber());
		paymentPort.save(payment);


		return ResponseEntity.ok().build();
	}
}
