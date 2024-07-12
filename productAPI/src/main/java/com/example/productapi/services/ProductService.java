package com.example.productapi.services;

import com.example.productapi.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long productId) throws Exception;
    Product createProduct(Product product);
    void deleteProduct(Long productId) throws Exception;
}