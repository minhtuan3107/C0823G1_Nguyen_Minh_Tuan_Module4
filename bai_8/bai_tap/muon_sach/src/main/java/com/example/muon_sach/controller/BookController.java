package com.example.muon_sach.controller;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.CodeBook;
import com.example.muon_sach.service.IBookService;
import com.example.muon_sach.service.ICodeBookService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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


    private int requestToServer = 0;

    @Pointcut("within(com.example.muon_sach.*)")
    public void countRequestToServer() {
    }

    @Before("countRequestToServer()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
        this.requestToServer++;
        System.out.println("Request to server:" + this.requestToServer + " time");
    }
}
