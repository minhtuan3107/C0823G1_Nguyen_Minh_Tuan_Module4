package com.example.service;


import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getList() {
        return productRepository.getList();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
   public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
   }
}
