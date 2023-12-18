package com.example.Controller;

import com.example.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Tuan", "Tuan@gmail.com", "Da Nang"));
    }


    @GetMapping("/customers")
    public String getList(Model model) {
        model.addAttribute("customerList", customerList);
        return "/customers/list";
    }
}
