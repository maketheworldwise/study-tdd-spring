package com.example.main.order;

import com.example.main.product.Product;

interface OrderPort {
	Product getProductById(Long productId);

	void save(Order order);
}
