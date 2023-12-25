package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> getList() {
        return blogRepository.getList();
    }

    @Override
    public void remove(int id) {
        blogRepository.remove(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }
}
