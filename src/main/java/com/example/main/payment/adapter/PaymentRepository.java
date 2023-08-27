package com.example.main.payment.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.payment.domain.Payment;

interface PaymentRepository extends JpaRepository<Payment, Long> {
}
