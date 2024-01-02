package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.service.IClassRomService;
import com.example.demo.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRomService classRomService;

//    @GetMapping()
//    private String home(Model model) {
//        model.addAttribute("listStudent", studentService.getList());
//        model.addAttribute("classRom", classRomService.getList());
//        return "/index";
//    }

    @GetMapping("")
    private String home(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("age").ascending());
        Page<Student> listStudent = studentService.getListBlog(searchName, pageable);
        model.addAttribute("listStudent", listStudent);
        model.addAttribute("searchName", searchName);
        model.addAttribute("classRom", classRomService.getList());
        model.addAttribute("students", studentService.getList());
        return "index";
    }

    @GetMapping("search")
    private String search(Model model, @RequestParam String gender) {
        model.addAttribute("listStudent", studentService.displayStudentGender(gender));
        return "/index";
    }


    @GetMapping("add")
    private String formAdd(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        model.addAttribute("classRoom", classRomService.getList());
        return "add";
    }

    @GetMapping("addStudent")
    private String addStudent(@Valid @ModelAttribute StudentDTO studentDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        Student student = new Student();
        new StudentDTO().validate(studentDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("classRoom", classRomService.getList());
            return "add";
        }
        BeanUtils.copyProperties(studentDTO, student);
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    private String formEdit(Model model, @PathVariable int id) {
        Student student = studentService.findMyId(id);
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        model.addAttribute("studentDTO", studentDTO);
        model.addAttribute("classRom", classRomService.getList());
        return "edit";
    }

    @GetMapping("editStudent")
    private String editStudent(@Valid @ModelAttribute StudentDTO studentDTO, BindingResult bindingResult, Model model) {
        new StudentDTO().validate(studentDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("classRom", classRomService.getList());
            return "edit";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    private String formDelete(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findMyId(id));
        return "delete";
    }

    @ExceptionHandler(Exception.class)
    private String getError() {
        return "error";
    }
}