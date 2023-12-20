package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("listProduct", productService.getList());
        return "/index";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam String name, Model model) {
        List<Product> list = productService.search(name);
        model.addAttribute("listProduct", list);
        return "/index";
    }

    @GetMapping("/add")
    public String formAdd(Model model) {
        model.addAttribute("product", new Product());
        return "/add";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable int id, Model model) {
        Product product = productService.info(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @GetMapping("/info/{id}")
    public String infoProduct(@PathVariable int id, Model model) {
        Product product = productService.info(id);
        model.addAttribute("listProduct", product);
        return "/index";
    }

    @GetMapping("/delete/{id}")
    public String formDelete(@PathVariable int id, Model model) {
        Product product = productService.info(id);
        model.addAttribute("product", product);
        return "/delete";
    }

    @GetMapping("/addProduct")
    public String addProduct(Product product) {
        int id = 0;
        for (Product product1 : productService.getList()) {
            id = product1.getId();
        }
        product.setId(id + 1);
        productService.add(product);
        return "redirect:/";
    }

    @PostMapping("/editProduct")
    public String editProduct(Product product) {
        productService.edit(product);
        return "redirect:/";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(Product product) {
        int id = product.getId();
        productService.remove(id);
        return "redirect:/";
    }
}
