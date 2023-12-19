package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping()
    public String showForm() {
        return "/index";
    }

    @GetMapping("/clock")
    public String timeCity(@RequestParam(name = "city", defaultValue = "Asia/Ho_Chi_Minh", required = false) String city, Model model) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locate = TimeZone.getTimeZone(city);
        long localTime = date.getTime() + (locate.getRawOffset() - local.getRawOffset());
        date.setTime(localTime);
        model.addAttribute("time", date);
        return "/index";
    }
}
