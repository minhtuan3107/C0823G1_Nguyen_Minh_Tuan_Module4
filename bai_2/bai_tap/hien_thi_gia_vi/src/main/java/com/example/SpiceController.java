package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceController {
    @GetMapping()
    public String home() {
        return "/index";
    }

    @GetMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "") String[] condiment, Model model) {
        if (condiment.length == 0) {
            model.addAttribute("text", "Vui lòng chọn");
            return "/index";
        }
        model.addAttribute("condiment", condiment);
        return "/result";
    }
}
