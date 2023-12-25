package com.example.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String all;

    public Blog() {
    }

    public Blog(int id, String text, String all) {
        this.id = id;
        this.text = text;
        this.all = all;
    }

    public Blog(String text, String all) {
        this.text = text;
        this.all = all;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
