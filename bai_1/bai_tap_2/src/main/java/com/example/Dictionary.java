package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        map.put("bird","Con chim");

    }

    @GetMapping("")
    public String formSearch() {
        return "/index";
    }

    @GetMapping("/dictionary")
    public String translate(@RequestParam String name, Model model) {
        String result = null;
        for (Map.Entry<String, String> mapSearch : map.entrySet()) {
            if (mapSearch.getKey().toLowerCase().contains(name)) {
                result = "Kết quả của từ khóa: " + mapSearch.getKey() + " là: " + mapSearch.getValue();
                break;
            }
        }
        if (result == null) {
            result = "Không tìm thấy";
        }
        model.addAttribute("result", result);
        return "/index";
    }
}
