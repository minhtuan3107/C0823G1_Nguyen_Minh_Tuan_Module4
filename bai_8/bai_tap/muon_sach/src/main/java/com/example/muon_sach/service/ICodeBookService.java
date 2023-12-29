package com.example.muon_sach.service;

import com.example.muon_sach.model.CodeBook;

public interface ICodeBookService {
    int generateId();

    CodeBook findById(int id);

    void save(CodeBook codeBook);

    void delete(int id);
}
