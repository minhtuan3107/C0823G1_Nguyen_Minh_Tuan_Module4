package com.example.repository;

import com.example.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> getList();

    Blog findMyId(int id);

    void save(Blog blog);

    void remove(int id);
}
