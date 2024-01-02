package com.example.product.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "longtext")
    private String img;
    private float price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(int id, String name, String img, float price, Category category) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getId() == product.getId() && Float.compare(product.getPrice(), getPrice()) == 0 && getName().equals(product.getName()) && getImg().equals(product.getImg()) && getCategory().equals(product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getImg(), getPrice(), getCategory());
    }
}
