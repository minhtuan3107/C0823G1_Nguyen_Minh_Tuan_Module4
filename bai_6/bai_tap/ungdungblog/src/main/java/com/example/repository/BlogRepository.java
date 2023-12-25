package com.example.repository;

import com.example.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Blog blog) {

    }

    @Override
    public List<Blog> getList() {
        List<Blog> blogs = new ArrayList<>();
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b ", Blog.class);
        blogs = query.getResultList();
        return blogs;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Blog findById(int id) {
        return null;
    }
}
