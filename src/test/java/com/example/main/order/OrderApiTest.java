package com.example.main.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.example.main.ApiTest;
import com.example.main.product.ProductSteps;

class OrderApiTest extends ApiTest {

	@Test
	void orderProduct() {
		ProductSteps.addProductRequest(ProductSteps.getAddProductRequest());
		final CreateOrderRequest request = OrderSteps.getAddOrderRequest();

		final var response = OrderSteps.getOrderRequest(request);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

}
