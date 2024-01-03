package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where product.name like :name", nativeQuery = true)
    Page<Product> getListProduct(@Param("name") String name, Pageable pageable);

    @Query(value = "select * from product left join category on product.id = category.id where category.name like :categoryName", nativeQuery = true)
    Page<Product> searchProduct(@Param("categoryName") String categoryName, Pageable pageable);
}
