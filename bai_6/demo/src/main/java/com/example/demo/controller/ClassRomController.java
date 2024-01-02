package com.example.demo.controller;

import com.example.demo.model.ClassRoom;
import com.example.demo.service.IClassRomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClassRomController {
    @Autowired
    private IClassRomService classRomService;

    @GetMapping("classRoom")
    private String home(Model model) {
        model.addAttribute("listClassRoom", classRomService.getList());
        return "listClassRoom";
    }

    @GetMapping("classRoom/add")
    private String formAdd(Model model) {
        model.addAttribute("classRoom", new ClassRoom());
        return "addClassRoom";
    }

    @GetMapping("addClassRoom")
    private String add(ClassRoom classRoom) {
        classRomService.save(classRoom);
        return "redirect:/classRoom";
    }

    @GetMapping("classRoom/edit/{id}")
    private String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("classRoom", classRomService.findMyId(id));
        return "editClassRoom";
    }

    @GetMapping("editClassRoom")
    private String edit(ClassRoom classRoom) {
        classRomService.save(classRoom);
        return "redirect:/classRoom";
    }

    @ExceptionHandler(Exception.class)
    private String getError() {
        return "error";
    }
}
