package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getList();

    Optional<Product> findById(int id);

    void save(Product product);

    void remove(Product product);

    Page<Product> getListProduct(String name, Pageable pageable);
}
