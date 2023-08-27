package com.example.main.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.example.main.ApiTest;
import com.example.main.order.OrderSteps;
import com.example.main.product.ProductSteps;

public class PaymentApiTest extends ApiTest {

	@Test
	void paymentOrder() {
		ProductSteps.addProductRequest(ProductSteps.getAddProductRequest());
		OrderSteps.addOrderRequest(OrderSteps.getAddOrderRequest());

		final var request = PaymentSteps.getAddPaymentRequest();
		final var response = PaymentSteps.addPaymentOrderRequest(request);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
	}

}
