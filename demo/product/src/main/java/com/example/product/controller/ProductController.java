package com.example.product.controller;

import com.example.product.model.Cart;
import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.service.ICategoryService;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.getList());
        if (cart.countItemQuantity() != 0) {
            modelAndView.addObject("itemsInCart", cart.countItemQuantity());
        } else {
            modelAndView.addObject("itemsInCart", 0);
        }
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/";
    }

    @GetMapping("/minus/{id}")
    public String deleteToCart(@PathVariable int id,
                               @ModelAttribute Cart cart,
                               @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.deleteProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/";
    }

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @GetMapping()
    private String home(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 2);
        model.addAttribute("product", productService.getListProduct(searchName, pageable));
        return "index";
    }


    @GetMapping("addProducts")
    private String formAdd(Model model) {
        model.addAttribute("category", categoryService.getList());
        model.addAttribute("product", new Product());
        return "add";
    }

    @GetMapping("addProduct")
    private String addProduct(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    private String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.getList());
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @GetMapping("editProduct")
    private String editProduct(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    private String formDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @GetMapping("deleteProduct")
    private String deleteProduct(Product product) {
        productService.remove(product);
        return "redirect:/";
    }

    // category
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
