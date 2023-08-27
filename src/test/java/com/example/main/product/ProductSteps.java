package com.example.main.product;

import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class ProductSteps {
	public static ExtractableResponse<Response> addProductRequest(AddProductRequest request) {
		return RestAssured.given()
			.log()
			.all()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(request)
			.when()
			.post("/products")
			.then()
			.log()
			.all()
			.extract();
	}

	public static AddProductRequest getAddProductRequest() {
		final String name = "product";
		final int price = 1000;
		final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
		return new AddProductRequest(name, price, discountPolicy);
	}

	public static ExtractableResponse<Response> getProductResponse(Long productId) {
		return RestAssured.given()
			.log()
			.all()
			.when()
			.get("/products/{productId}", productId)
			.then()
			.log()
			.all()
			.extract();
	}

	static UpdateProductRequest getUpdateProductRequest() {
		return new UpdateProductRequest("modify", 2000, DiscountPolicy.NONE);
	}
}