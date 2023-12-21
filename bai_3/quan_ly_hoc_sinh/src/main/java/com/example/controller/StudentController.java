package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService service;

    @GetMapping()
    private String home(Model model) {
        model.addAttribute("listStudent", service.getList());
        return "/index";
    }

    @GetMapping("/add")
    private String formAddStudent(Model model) {
        model.addAttribute("student", new Student());
        return "/add";
    }

    @PostMapping("/addStudent")
    private String addStudent(@ModelAttribute Student student) {
//        int id;
//        for (Student student1 : service.getList()) {
//            id = student1.getId();
//        }
        student.setId((int) (Math.random() * 1000000));
        service.add(student);
        return "redirect:/index";
    }

    @GetMapping("search")
    private String searchGender(@RequestParam String gender, Model model) {
        List<Student> list = service.displayGender(gender);
        model.addAttribute("listStudent", list);
        return "/index";
    }

    @GetMapping("/edit/{id}")
    private String showFormEdit(Model model, @PathVariable int id) {
        for (Student student : service.getList()) {
            if (student.getId() == id) {
                model.addAttribute("student", student);
            }
        }
        return "/edit";
    }

    @PostMapping("/editStudent")
    private String editStudent(Student student) {
        service.edit(student);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    private String formDelete(Model model, @PathVariable int id) {
        for (Student student : service.getList()) {
            if (student.getId() == id) {
                model.addAttribute("student", student);
            }
        }
        return "/delete";
    }

    @PostMapping("/deleteStudent")
    private String deleteStudent(Student student) {
        System.out.println(student.getId());
        service.remove(student.getId());
        return "redirect:/index";
    }

    @GetMapping("/sort")
    private String sortStudent(Model model) {
        model.addAttribute("listStudent", service.sort());
        return "/index";
    }

}
