package com.example.main.product.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
