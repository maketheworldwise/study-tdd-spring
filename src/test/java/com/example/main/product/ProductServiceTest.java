package com.example.main.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	void getProduct() {
		productService.addProduct(ProductSteps.getAddProductRequest());
		final Long productId = 1L;

		final GetProductResponse response = productService.getProduct(productId);

		assertThat(response).isNotNull();
	}

}