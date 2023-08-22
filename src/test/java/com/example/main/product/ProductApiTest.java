package com.example.main.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.example.main.ApiTest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class ProductApiTest extends ApiTest {

	@Test
	void addProduct() {
		final var request = ProductSteps.getAddProductRequest();
		final var response = ProductSteps.addProductRequest(request);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

	@Test
	void getProduct() {
		ProductSteps.addProductRequest(ProductSteps.getAddProductRequest());
		Long productId = 1L;

		ExtractableResponse<Response> response = RestAssured.given()
			.log()
			.all()
			.when()
			.get("/products/{productId}", productId)
			.then()
			.log()
			.all()
			.extract();

		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.jsonPath().getString("name")).isEqualTo("product");
	}

}
