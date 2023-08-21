package com.example.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	void addProduct() {
		final AddProductRequest request = getAddProductRequest();
		productService.addProduct(request);
	}

	private static AddProductRequest getAddProductRequest() {
		final String name = "product";
		final int price = 1000;
		final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
		return new AddProductRequest(name, price, discountPolicy);
	}
}
