package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class Dictionary {
    private static Map<String, String> map = new LinkedHashMap<>();

    static {
        map.put("chicken", "Con Gà");
        map.put("duck", "Con Vịt");
        map.put("dog", "Con Chó");
        map.put("cat", "Con Mèo");
        map.put("pig", "Con Heo");
        map.put("cow", "Con Bò");
        map.put("bird", "Con chim");
    }

    @GetMapping("")
    public String formSearch() {
        return "/index";
    }

    @GetMapping("/dictionary")
    public String translate(@RequestParam String name, Model model) {
        String result = map.get(name.toLowerCase());
        if (result == null) {
            result = "Không tìm thấy";
        }
        model.addAttribute("result", result);
        return "/index";
    }
}
