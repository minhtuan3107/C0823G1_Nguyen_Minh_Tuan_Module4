package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

@Controller
public class CheckEmailController {
    private final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    @GetMapping("")
    public String showForm() {
        return "/index";
    }

    @PostMapping("/validate")
    public String check(@RequestParam("email") String email, ModelMap modelMap) {
        boolean checkValidate = checkRegex(email);
        if (checkValidate == false) {
            modelMap.addAttribute("result", "Email không đúng định dạng");
            return "/index";
        }
        modelMap.addAttribute("result", email + " Đúng định dạng");
        return "/index";
    }

    private boolean checkRegex(String regex) {
        return Pattern.matches(REGEX_EMAIL, regex);
    }
}
