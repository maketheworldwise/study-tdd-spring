package com.example.main.product;

interface ProductPort {
	void save(final Product product);

	Product getProduct(Long productId);
}
