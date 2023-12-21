package com.example.repository;

import com.example.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getList();

    void edit(Student student);

    void add(Student student);

    void remove(int id);

    List<Student> sort();

    List<Student> displayGender(String male);
}
