package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getList() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findMyId(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Category> findMyIdCategory(int id) {
        return findMyIdCategory(id);
    }

    @Override
    public Page<Blog> getListBlog(String name, Pageable pageable) {
        return blogRepository.search("%" + name + "%", pageable);
    }
}
