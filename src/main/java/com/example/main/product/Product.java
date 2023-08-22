package com.example.main.product;

import org.springframework.util.Assert;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int price;

	private DiscountPolicy discountPolicy;

	public Product(String name, int price, DiscountPolicy discountPolicy) {
		Assert.hasText(name, "name must be declared");
		Assert.isTrue(price > 0, "price must be over 0");
		Assert.notNull(discountPolicy, "discount policy required");
		this.name = name;
		this.price = price;
		this.discountPolicy = discountPolicy;
	}

	public void update(String name, int price, DiscountPolicy discountPolicy) {
		Assert.hasText(name, "name must be declared");
		Assert.isTrue(price > 0, "price must be over 0");
		Assert.notNull(discountPolicy, "discount policy required");
		this.name = name;
		this.price = price;
		this.discountPolicy = discountPolicy;

	}
}
