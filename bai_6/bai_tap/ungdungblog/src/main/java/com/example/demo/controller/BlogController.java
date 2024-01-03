package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    private String home(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("time_create_blog").ascending());
        Page<Blog> blogPage = blogService.getListBlog(searchName, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("category", categoryService.getList());
        model.addAttribute("blog", blogService.getList());
        return "index";
    }

    @GetMapping("add")
    private String formAdd(Model model) {
        model.addAttribute("categoryList", categoryService.getList());
        model.addAttribute("blog", new Blog());
        return "add";
    }

    @GetMapping("addBlog")
    private String add(Blog blog) {
        blog.setTimeCreateBlog(LocalDateTime.now());
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("info/{id}")
    private String formInfo(@PathVariable int id, Model model) {
        Blog blog = blogService.findMyId(id);
        model.addAttribute("blog", blog);
        return "info";
    }

    @GetMapping("edit/{id}")
    private String formEdit(@PathVariable int id, Model model) {
        Blog blog = blogService.findMyId(id);
        model.addAttribute("categoryList", categoryService.getList());
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("editBlog")
    private String editBlog(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    private String formDelete(@PathVariable int id, Model model) {
        Blog blog = blogService.findMyId(id);
        model.addAttribute("blog", blog);
        return "delete";
    }

    @PostMapping("deleteBlog")
    private String deleteBlog(Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:/";
    }

    @GetMapping("category")
    private String homeCategory(Model model) {
        model.addAttribute("category", categoryService.getList());
        return "category/index";
    }

    @GetMapping("/category/delete/{id}")
    private String formDeleteCategory(Model model, @PathVariable int id) {
        Category category = categoryService.findMyId(id);
        model.addAttribute("category", category);
        return "/category/delete";
    }

    @PostMapping("/category/deleteCategory")
    private String deleteCategory(Category category) {
        categoryService.remove(category.getId());
        return "redirect:/category";
    }

    @GetMapping("/category/add")
    private String formAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/category/add";
    }

    @GetMapping("/category/addCategory")
    private String addCategory(Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/category/edit/{id}")
    private String formEditCategory(Model model, @PathVariable int id) {
        model.addAttribute("category", categoryService.findMyId(id));
        return "/category/edit";
    }
    @PostMapping("/category/editCategory")
    private String editCategory(Category category){
        categoryService.save(category);
        return "redirect:/category";
    }
}