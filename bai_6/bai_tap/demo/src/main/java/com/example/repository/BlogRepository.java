package com.example.repository;

import com.example.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> getList() {
        TypedQuery<Blog> typedQuery = entityManager.createQuery("from Blog", Blog.class);
        return typedQuery.getResultList();
    }

    @Override
    public Blog findMyId(int id) {
        TypedQuery<Blog> typedQuery = entityManager.createQuery("select b from Blog b where b.id = :id", Blog.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Transactional
    @Override
    public void save(Blog blog) {
        if (blog.getId() == 0) {
            entityManager.persist(blog);
        } else {
            Blog blog1 = findMyId(blog.getId());
            blog1.setName(blog.getName());
            blog1.setTexts(blog.getTexts());
            blog1.setAlls(blog1.getAlls());
            entityManager.merge(blog1);
        }
    }

    @Transactional
    @Override
    public void remove(int id) {
        entityManager.remove(findMyId(id));
    }

}
