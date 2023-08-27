package com.example.main.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.main.ApiTest;
import com.example.main.product.adapter.ProductRepository;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class ProductApiTest extends ApiTest {

	@Autowired
	ProductRepository productRepository;

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

		final var response = ProductSteps.getProductResponse(productId);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.jsonPath().getString("name")).isEqualTo("product");
	}

	@Test
	void modifyProduct() {
		ProductSteps.addProductRequest(ProductSteps.getAddProductRequest());

		final Long productId = 1L;

		final ExtractableResponse<Response> response = getModifyProductResponse(productId);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		// assertThat(productRepository.findById(1L).get().getName()).isEqualTo("modify");
	}

	private static ExtractableResponse<Response> getModifyProductResponse(Long productId) {
		final ExtractableResponse<Response> response = RestAssured.given()
			.log()
			.all()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(ProductSteps.getUpdateProductRequest())
			.when()
			.patch("/products/{productId}", productId)
			.then()
			.log()
			.all()
			.extract();
		return response;
	}
}
