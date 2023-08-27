package com.example.main.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ProductServiceTest {
	@Autowired
	private ProductService productService;

	@Test
	void updateProduct() {
		productService.addProduct(ProductSteps.getAddProductRequest());
		final Long productId = 1L;
		final UpdateProductRequest request = ProductSteps.getUpdateProductRequest();

		productService.updateProduct(productId, request);

		final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
		final GetProductResponse productResponse = response.getBody();

		assertThat(productResponse.name()).isEqualTo("modify");
		assertThat(productResponse.price()).isEqualTo(2000);
	}

}
