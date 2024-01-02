package com.example.product.service;

import com.example.product.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> getList();

    Category findById(int id);

    void save(Category category);

    Page<Category> getListCategory(String name, Pageable pageable);

    void delete(Category category);
}
