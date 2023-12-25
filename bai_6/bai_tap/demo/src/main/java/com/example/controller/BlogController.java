package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    private String home(Model model) {
        model.addAttribute("blog", blogService.getList());
        return "/index";
    }

    @GetMapping("/info/{id}")
    private String showInfo(@PathVariable int id, Model model) {
        Blog blog = blogService.findMyId(id);
        model.addAttribute("blog", blog);
        return "/info";
    }

    @GetMapping("/add")
    private String showAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "/add";
    }

    @GetMapping("/edit/{id}")
    private String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findMyId(id));
        return "/edit";
    }

    @GetMapping("/delete/{id}")
    private String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findMyId(id));
        return "/delete";
    }

    @GetMapping("addBlog")
    private String addBlog(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("editBlog")
    private String editBlog(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("deleteBlog")
    private String deleteBlog(Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:/";
    }
}
