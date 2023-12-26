package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getList();

    void save(Blog blog);

    void remove(int id);

    Blog findMyId(int id);

    List<Category> findMyIdCategory(int id);

    Page<Blog> getListBlog(String name, Pageable pageable);
}
