package com.example.main.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.main.ApiTest;
import com.example.main.product.ProductSteps;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

class OrderApiTest extends ApiTest {

	@Test
	void orderProduct() {
		ProductSteps.addProductRequest(ProductSteps.getAddProductRequest());
		final CreateOrderRequest request = getAddOrderRequest();

		ExtractableResponse<Response> response = RestAssured.given()
			.log()
			.all()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(request)
			.when()
			.post("/orders")
			.then()
			.log()
			.all()
			.extract();

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

	private static CreateOrderRequest getAddOrderRequest() {
		final Long productId = 1L;
		final int quantity = 2;
		return new CreateOrderRequest(productId, quantity);
	}

}
