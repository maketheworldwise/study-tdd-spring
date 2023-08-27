package com.example.main.product.adapter;

import org.springframework.stereotype.Component;

import com.example.main.product.application.port.ProductPort;
import com.example.main.product.domain.Product;

@Component
class ProductAdapter implements ProductPort {
	private ProductRepository productRepository;

	ProductAdapter(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void save(final Product product) {
		productRepository.save(product);
	}

	@Override
	public Product getProduct(Long productId) {
		return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("no product"));
	}
}
