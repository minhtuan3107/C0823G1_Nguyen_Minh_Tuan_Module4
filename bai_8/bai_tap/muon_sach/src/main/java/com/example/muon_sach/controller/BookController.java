package com.example.muon_sach.controller;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.CodeBook;
import com.example.muon_sach.service.IBookService;
import com.example.muon_sach.service.ICodeBookService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Component
@Aspect
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICodeBookService iCodeBookService;

    @GetMapping()
    private String home(Model model) {
        model.addAttribute("book", bookService.getList());
        return "index";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "detail";
    }

    @GetMapping("/addBook")
    private String formAdd(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    @GetMapping("add")
    private String add(Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/borrow")
    public String borrow(@ModelAttribute Book book, Model model) {
        if (book.getQuantity() <= 1) {
            model.addAttribute("mess", 2);
            return "index";
        }
        bookService.save(book);
        int id = iCodeBookService.generateId();
        CodeBook codeBook = new CodeBook(id, book);
        iCodeBookService.save(codeBook);
        model.addAttribute("id", id);
        return "borrow";
    }


    @GetMapping("search")
    private String search(@RequestParam int quantity, Model model) {
        try {
            CodeBook codeBook = iCodeBookService.findById(quantity);
            Book book = bookService.findById(codeBook.getBook().getBookId());
            book.setQuantity(book.getQuantity() + 2);
            bookService.save(book);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("mess", 1);
            return "index";
        }

    }


    @After("execution(* com.example.muon_sach.service.BookService.*(..))")
    public void logBookStateChange(JoinPoint joinPoint) {
        System.out.println("Book state changed: " + joinPoint.getSignature().getName());
        // Ghi log về thay đổi trạng thái sách ở đây
    }

    @AfterThrowing(pointcut = "execution(* com.example.muon_sach.service.BookService.*(..))", throwing = "ex")
    public void logBookServiceException(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Exception in method " + joinPoint.getSignature().getName() + ": " + ex.getMessage());
        // Ghi log về ngoại lệ xảy ra ở đây
    }

    @After("execution(* com.example.muon_sach.service.BookService.getList(..))")
    public void logLibraryVisit(JoinPoint joinPoint) {
        System.out.println("Library visited: " + joinPoint.getSignature().getName());
        // Ghi log về việc ghé thăm thư viện ở đây
    }

    @ExceptionHandler(Exception.class)
    private String getError() {
        return "error";
    }
}
