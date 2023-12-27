package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.IClassRomService;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRomService classRomService;

    @GetMapping()
    private String home(Model model) {
        model.addAttribute("listStudent", studentService.getList());
        model.addAttribute("classRom", classRomService.getList());
        return "/index";
    }

    @GetMapping("search")
    private String search(Model model, @RequestParam String gender) {
        model.addAttribute("listStudent", studentService.displayStudentGender(gender));
        return "/index";
    }



    @GetMapping("sort")
    private String sort(Model model) {
        model.addAttribute("listStudent", studentService.sortStudentsByAge());
        return "/index";
    }

    @GetMapping("add")
    private String formAdd(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classRom", classRomService.getList());
        return "add";
    }

    @GetMapping("addStudent")
    private String addStudent(Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    private String formEdit(Model model, @PathVariable int id) {
        model.addAttribute("student", studentService.findMyId(id));
        model.addAttribute("classRom", classRomService.getList());
        return "edit";
    }

    @GetMapping("editStudent")
    private String editStudent(Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    private String formDelete(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findMyId(id));
        return "delete";
    }
}