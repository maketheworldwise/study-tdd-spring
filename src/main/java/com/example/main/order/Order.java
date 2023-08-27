package com.example.main.order;

import org.springframework.util.Assert;

import com.example.main.product.Product;

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
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Product product;

	@Column
	private int quantity;

	public Order(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		Assert.notNull(product, "product must be required");
		Assert.isTrue(quantity > 0, "quantity must be over 0");
	}

}
