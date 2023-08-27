package com.example.main.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.main.product.ProductService;
import com.example.main.product.ProductSteps;

@SpringBootTest
class OrderServiceTest {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Test
	void orderProduct() {
		productService.addProduct(ProductSteps.getAddProductRequest());

		final CreateOrderRequest request = getAddOrderRequest();

		orderService.createOrder(request);
	}

	private static CreateOrderRequest getAddOrderRequest() {
		final Long productId = 1L;
		final int quantity = 2;
		return new CreateOrderRequest(productId, quantity);
	}

}
