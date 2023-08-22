package com.example.main.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {
	private ProductService productService;

	private StubProductPort productPort = new StubProductPort();

	@BeforeEach
	void setUp() {
		productService = new ProductService(productPort);
	}

	@Test
	void updateProduct() {
		final Long productId = 1L;
		final UpdateProductRequest request = new UpdateProductRequest("modify", 2000, DiscountPolicy.NONE);
		final Product product = new Product("product", 1000, DiscountPolicy.NONE);

		productPort.getProductWillReturn = product;
		productService.updateProduct(productId, request);

		assertThat(product.getName()).isEqualTo("modify");
		assertThat(product.getPrice()).isEqualTo(2000);
	}

	private static class StubProductPort implements ProductPort {
		public Product getProductWillReturn;

		@Override
		public void save(Product product) {
		}

		@Override
		public Product getProduct(Long productId) {
			return getProductWillReturn;
		}
	}
}
