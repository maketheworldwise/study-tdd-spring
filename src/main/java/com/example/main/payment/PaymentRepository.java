package com.example.main.payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
class PaymentRepository {

	private Long sequence = 0L;
	private Map<Long, Payment> persistence = new HashMap<>();

	public void save(Payment payment) {
		payment.assignId(++sequence);
		persistence.put(payment.getId(), payment);
	}
}
