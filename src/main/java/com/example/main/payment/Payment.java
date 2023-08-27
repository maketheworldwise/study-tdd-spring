package com.example.main.payment;

import org.springframework.util.Assert;

import com.example.main.order.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Order order;

	@Column
	private String cardNumber;

	public Payment(Order order, String cardNumber) {
		Assert.notNull(order, "order must be required");
		Assert.hasText(cardNumber, "cardNumber must have text");
		this.order = order;
		this.cardNumber = cardNumber;
	}

	public int getPrice() {
		return order.getTotalPrice();
	}

	public String getCardNumber() {
		return this.cardNumber;
	}
}
