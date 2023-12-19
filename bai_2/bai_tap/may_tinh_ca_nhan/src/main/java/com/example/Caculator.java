package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Caculator {
    @GetMapping("")
    public String home() {
        return "/index";
    }

    @GetMapping("/caculator")
    public String calculator(@RequestParam(value = "firstNumber", defaultValue = "0.0") double firstNumber,
                             @RequestParam(value = "secondNumber", defaultValue = "0.0") double secondNumber,
                             @RequestParam(value = "operator") String operator,
                             Model model) {
        double result = 0.0;
        switch (operator) {
            case "Cộng":
                result = firstNumber + secondNumber;
                break;
            case "Trừ":
                result = firstNumber - secondNumber;
                break;
            case "Nhân":
                result = firstNumber * secondNumber;
                break;
            case "Chia":
                if (secondNumber == 0) {
                    model.addAttribute("result", "Không thể chia cho không");
                    return "/index";
                }
                result = firstNumber / secondNumber;
                break;
        }
        model.addAttribute("result", "Kết quả là: " + result);
        return "/index";
    }
}
