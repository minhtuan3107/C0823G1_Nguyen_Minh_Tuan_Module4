package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String texts;
    private String alls;

    public Blog() {
    }

    public Blog(String name, String texts, String alls) {
        this.name = name;
        this.texts = texts;
        this.alls = alls;
    }

    public Blog(String texts, String alls) {
        this.texts = texts;
        this.alls = alls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public String getAlls() {
        return alls;
    }

    public void setAlls(String alls) {
        this.alls = alls;
    }
}
