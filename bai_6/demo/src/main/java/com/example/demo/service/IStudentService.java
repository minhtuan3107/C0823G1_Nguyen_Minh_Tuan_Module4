package com.example.demo.service;

import com.example.demo.model.ClassRoom;
import com.example.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getList();

    void save(Student student);

    void remove(Student student);

    Student findMyId(int id);

    List<Student> displayStudentGender(String gender);

    List<Student> sortStudentsByAge();
}
