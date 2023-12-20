package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    private String home(Model model) {
        model.addAttribute("list", customerService.getList());
        model.addAttribute("customer", new Customer());
        return "/index";
    }

    @GetMapping("/add")
    private String add(@ModelAttribute Customer customer) {
        customer.setId((int) (Math.random() * 1000));
        customerService.add(customer);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    private String edit(@PathVariable int id, Model model) {
        for (Customer customer : customerService.getList()) {
            if (customer.getId() == id) {
                model.addAttribute("customer", customer);
                break;
            }
        }
        return "/edit";
    }

    @PostMapping("/update")
    private String update(@ModelAttribute Customer customer) {
        System.out.println(customer.getId());
        customerService.edit(customer);
        return "redirect:/index";
    }
    @PostMapping("/delete")
    private String delete(@RequestParam int idEdit, Model model){
        System.out.println(idEdit);
        boolean check = customerService.remove(idEdit);
        model.addAttribute("check", check);
        return "redirect:index";
    }
}
