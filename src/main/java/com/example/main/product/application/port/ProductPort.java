package com.example.main.product.application.port;

import com.example.main.product.domain.Product;

public interface ProductPort {
	void save(final Product product);

	Product getProduct(Long productId);
}
