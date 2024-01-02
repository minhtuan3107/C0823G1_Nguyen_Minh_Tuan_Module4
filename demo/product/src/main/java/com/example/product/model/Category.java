package com.example.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Category {
    @Id
    private int Id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Category> categories;

    public Category() {
    }

    public Category(int id, String name, Set<Category> categories) {
        Id = id;
        this.name = name;
        this.categories = categories;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
