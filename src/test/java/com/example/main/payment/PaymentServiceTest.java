package com.example.main.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.main.order.OrderService;
import com.example.main.order.OrderSteps;
import com.example.main.product.ProductService;
import com.example.main.product.ProductSteps;

@SpringBootTest
public class PaymentServiceTest {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Test
	void paymentOrder() {
		productService.addProduct(ProductSteps.getAddProductRequest());
		orderService.createOrder(OrderSteps.getAddOrderRequest());

		final PaymentRequest request = PaymentSteps.getAddPaymentRequest();
		paymentService.payment(request);
	}
}
