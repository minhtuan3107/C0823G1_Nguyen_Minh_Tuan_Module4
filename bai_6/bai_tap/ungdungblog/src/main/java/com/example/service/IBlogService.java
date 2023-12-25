package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    void save(Blog blog);

    List<Blog> getList();

    void remove(int id);

    Blog findById(int id);
}
