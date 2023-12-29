package com.example.muon_sach.repository;

import com.example.muon_sach.model.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeBookRepository extends JpaRepository<CodeBook, Integer> {
}
