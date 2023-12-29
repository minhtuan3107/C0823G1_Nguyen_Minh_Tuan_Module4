package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getList() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Student findMyId(int id) {
        return studentRepository.findById(id).get();
    }


    @Override
    public List<Student> displayStudentGender(String gender) {
        return studentRepository.findByGender(gender);
    }


    @Override
    public Page<Student> getListBlog(String name, Pageable pageable) {
        return studentRepository.search("%" + name + "%", pageable);
    }
}
