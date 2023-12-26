package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(nativeQuery = true, value = "select * from blog b join category c on b.category = c.id where c.id :id")
    List<Blog> findCategoriesById(@Param("") int id);

    @Query(value = "select * from blog where name like :name ", nativeQuery = true)
    Page<Blog> search(@Param("name") String name, Pageable pageable);
}
