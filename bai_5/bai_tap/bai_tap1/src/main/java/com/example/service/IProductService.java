package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();

    void save(Product product);

    Product findById(int id);

    void remove(int id);

    List<Product> searchByName(String name);
}
