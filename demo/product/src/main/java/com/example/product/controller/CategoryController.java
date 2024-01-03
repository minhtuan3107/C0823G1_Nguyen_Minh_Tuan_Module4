package com.example.product.controller;

import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.service.ICategoryService;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @GetMapping("category")
    private String homeCategory(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("category", categoryService.getListCategory(searchName, pageable));
        return "home_category";
    }

    @GetMapping("formAddCategory")
    private String formAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "add_category";
    }

    @GetMapping("addCategory")
    private String addCategory(Category category) {
        categoryService.save(category);
        return "redirect:/";
    }

    @GetMapping("formEditCategory/{id}")
    private String formEditCategory(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "edit_category";
    }

    @GetMapping("formDeleteCategory/{id}")
    private String formDeleteCategory(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "delete_category";
    }

    @GetMapping("deleteCategory")
    private String deleteCategory(Category category, Model model) {
        List<Product> products = productService.getList();
        for (Product product : products) {
            if (product.getCategory().getId() == category.getId()) {
                return "error_404";
            }
        }
        categoryService.delete(category);
        return "redirect:/";
    }

//    @GetMapping("category/editCategory")
//    private String formEdit(@RequestParam("categoryId") int categoryId, Model model) {
//        model.addAttribute("category", categoryService.findById(categoryId));
//        return "category/edit_category";
//    }

    @GetMapping("editCategory")
    private String editCategory(Category category) {
        categoryService.save(category);
        return "redirect:/";
    }
}
