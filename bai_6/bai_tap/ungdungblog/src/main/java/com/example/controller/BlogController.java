package com.example.controller;

import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    private String home(Model model){
        model.addAttribute("blog",blogService.getList());
        return "/index";
    }
}
