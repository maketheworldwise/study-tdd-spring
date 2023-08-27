package com.example.main.order.application.port;

import com.example.main.order.domain.Order;
import com.example.main.product.domain.Product;

public interface OrderPort {
	Product getProductById(Long productId);

	void save(Order order);
}
