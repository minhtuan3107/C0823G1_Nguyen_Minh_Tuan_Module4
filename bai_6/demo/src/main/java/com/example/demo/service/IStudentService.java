package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> getList();

    void save(Student student);

    void remove(Student student);

    Student findMyId(int id);

    List<Student> displayStudentGender(String gender);


    Page<Student> getListBlog(String name, Pageable pageable);

}
