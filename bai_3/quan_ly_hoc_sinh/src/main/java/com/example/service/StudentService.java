package com.example.service;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> getList() {
        return studentRepository.getList();
    }

    @Override
    public void add(Student student) {
        studentRepository.add(student);
    }

    @Override
    public void edit(Student student) {
        studentRepository.edit(student);
    }

    @Override
    public void remove(int id) {
        studentRepository.remove(id);
    }

    @Override
    public List<Student> sort() {
        return studentRepository.sort();
    }

    @Override
    public List<Student> displayGender(String male) {
        return studentRepository.displayGender(male);
    }
}
