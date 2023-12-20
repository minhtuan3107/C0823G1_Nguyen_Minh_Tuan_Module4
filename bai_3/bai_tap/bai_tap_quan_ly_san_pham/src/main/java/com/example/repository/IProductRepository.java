package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getList();

    void add(Product product);

    void edit(Product product);

    void remove(int id);

    Product info(int id);

    List<Product> search(String name);
}
