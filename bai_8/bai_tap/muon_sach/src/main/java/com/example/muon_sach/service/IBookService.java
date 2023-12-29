package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    void save(Book book);

    Book findById(int id);

    void delete(Book book);

    List<Book> getList();
}
