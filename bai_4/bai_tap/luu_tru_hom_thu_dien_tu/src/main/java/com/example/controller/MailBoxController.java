package com.example.controller;

import com.example.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxController {
    @GetMapping("")
    private String home(Model model) {
        model.addAttribute("mailBox", new MailBox());
        model.addAttribute("languagesArray", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizeArray", new int[]{5, 10, 15, 20, 25, 50, 100});
        return "/index";
    }
    @PostMapping("/addMailBox")
    private String updateMailBox(@ModelAttribute("mailBox") MailBox mailBox, Model model){
        model.addAttribute("mailBox",mailBox);
        return "/update";
    }
}
