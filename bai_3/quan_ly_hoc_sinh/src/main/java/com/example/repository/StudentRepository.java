package com.example.repository;

import com.example.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> list = new ArrayList<>();

    static {
        list.add(new Student(1, "MinhTuan", "Nam", 18, "Da Nang"));
        list.add(new Student(2, "AnhTuan", "Nam", 15, "Da Nang"));
        list.add(new Student(3, "Do", "Nam", 14, "Da Nang"));
        list.add(new Student(4, "Toai", "Nam", 13, "Da Nang"));
        list.add(new Student(5, "Khoa", "Nam", 15, "Da Nang"));
    }

    @Override
    public List<Student> getList() {
        return list;
    }

    @Override
    public void edit(Student student) {
        for (Student student1 : list) {
            if (student1.getId() == student.getId()) {
                student1.setName(student.getName());
                student1.setAge(student.getAge());
                student1.setAddress(student.getAddress());
                student1.setGender(student.getGender());
                break;
            }
        }
    }

    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public void remove(int id) {
        for (Student student : list) {
            if (student.getId() == id) {
                list.remove(student);
                break;
            }
        }
    }

    @Override
    public List<Student> sort() {
        List<Student> studentList = new ArrayList<>();
        for (Student student : list) {
            studentList.add(student);
        }
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return studentList;
    }

    @Override
    public List<Student> displayGender(String male) {
        List<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (student.getGender().equals(male)) {
                students.add(student);
            }
        }
        return students;
    }
}
