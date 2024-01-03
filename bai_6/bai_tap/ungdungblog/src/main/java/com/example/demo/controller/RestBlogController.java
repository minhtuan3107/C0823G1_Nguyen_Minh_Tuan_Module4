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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RestBlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> showListBlogs(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "") String searchName,
                                                    Model model) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("time_to_create_blog").ascending());
        Page<Blog> blogPage = iBlogService.getListBlog(searchName, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> showListCategories(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "") String searchName,
                                                             Model model) {
        List<Category> categoryPage = iCategoryService.getList();
        if (categoryPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> blogDetail(@PathVariable int id){
        try {
            Blog blog = iBlogService.findMyId(id);
            return new ResponseEntity<>(blog,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/detailCategory/{id}")
    public ResponseEntity<Category> categoryDetail(@PathVariable int id){
        try {
            Category category = iCategoryService.findMyId(id);
            return new ResponseEntity<>(category,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}