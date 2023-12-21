package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getList();

    void add(Student student);

    void edit(Student student);

    void remove(int id);

    List<Student> sort();

    List<Student> displayGender(String male);

}
