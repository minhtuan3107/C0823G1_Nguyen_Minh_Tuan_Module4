package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoney {
    @GetMapping("")
    public String display() {
        return "/index";
    }

    @GetMapping("/calculator")
    public String convert(@RequestParam double rate, double price, Model model) {
        double result = rate * price;
        model.addAttribute("result", result);
        return "/index";
    }
}
