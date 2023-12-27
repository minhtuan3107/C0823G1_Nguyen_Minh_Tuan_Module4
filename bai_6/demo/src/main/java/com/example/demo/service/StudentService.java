package com.example.demo.service;

import com.example.demo.model.ClassRoom;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Student> sortStudentsByAge() {
        return studentRepository.findAllByOrderByAgeAsc();
    }
}
