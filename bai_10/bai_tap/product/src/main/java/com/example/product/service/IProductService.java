package com.example.product.service;

import com.example.product.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
    void saveProduct(Product product);
    void deleteProduct(Long id);

}
