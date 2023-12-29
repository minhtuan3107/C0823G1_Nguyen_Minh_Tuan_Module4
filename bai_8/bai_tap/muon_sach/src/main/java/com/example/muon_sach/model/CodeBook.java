package com.example.muon_sach.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CodeBook {
    @Id
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public CodeBook(int id, Book book) {
        this.id = id;
        this.book = book;
    }
}