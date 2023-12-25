package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getList();

    Blog findMyId(int id);

    void save(Blog blog);

    void remove(int id);
}
