package com.example.main.order;

import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class OrderSteps {
	static ExtractableResponse<Response> getOrderRequest(CreateOrderRequest request) {
		return RestAssured.given()
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
	}

	public static CreateOrderRequest getAddOrderRequest() {
		final Long productId = 1L;
		final int quantity = 2;
		return new CreateOrderRequest(productId, quantity);
	}
}
