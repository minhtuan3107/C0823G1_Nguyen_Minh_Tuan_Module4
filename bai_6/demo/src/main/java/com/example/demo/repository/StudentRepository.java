package com.example.demo.repository;

import com.example.demo.model.ClassRoom;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByGender(String gender);

    List<Student> findAllByOrderByAgeAsc();


}
