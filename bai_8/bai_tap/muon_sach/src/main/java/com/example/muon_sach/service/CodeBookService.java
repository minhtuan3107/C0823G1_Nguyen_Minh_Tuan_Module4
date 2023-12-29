package com.example.muon_sach.service;

import com.example.muon_sach.model.CodeBook;
import com.example.muon_sach.repository.ICodeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeBookService implements ICodeBookService {
    @Autowired
    private ICodeBookRepository codeBookRepository;

    @Override
    public int generateId() {
        return (int) (Math.floor(Math.random() * 99999) + 10000);
    }

    @Override
    public CodeBook findById(int id) {
        return codeBookRepository.findById(id).get();
    }

    @Override
    public void save(CodeBook codeBook) {
        codeBookRepository.save(codeBook);
    }

    @Override
    public void delete(int id) {
        codeBookRepository.deleteById(id);
    }
}
