package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    void save(Category category);

    List<Category> getList();

    void remove(int id);

    Category findMyId(int id);
}
