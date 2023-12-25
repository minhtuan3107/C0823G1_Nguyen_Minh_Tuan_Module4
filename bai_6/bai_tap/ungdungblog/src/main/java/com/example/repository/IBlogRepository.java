package com.example.repository;

import com.example.model.Blog;

import java.util.List;

public interface IBlogRepository {
    void save(Blog blog);

    List<Blog> getList();

    void remove(int id);

    Blog findById(int id);
}
