package com.example.controller;

import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("list", customerService.getList());
        return "/index";
    }

    @GetMapping("/info")
    public String info(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("customer", customerService.info(id));
        return "/result";
    }
}
