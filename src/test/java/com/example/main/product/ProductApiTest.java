package com.example.main.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.example.main.ApiTest;

public class ProductApiTest extends ApiTest {

	@Test
	void addProduct() {
		final var request = ProductSteps.getAddProductRequest();
		final var response = ProductSteps.addProductRequest(request);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

}
