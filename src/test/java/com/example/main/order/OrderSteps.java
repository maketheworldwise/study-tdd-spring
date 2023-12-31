package com.example.main.order;

import org.springframework.http.MediaType;

import com.example.main.order.application.service.CreateOrderRequest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class OrderSteps {
	public static ExtractableResponse<Response> addOrderRequest(CreateOrderRequest request) {
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
