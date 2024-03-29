package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Product;
import com.example.demo.entities.Review;
import com.example.demo.services.ProductService;
import com.example.demo.services.ReviewService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("products") //! http://localhost:8080/products
public class ProductController {
  
  @Autowired
  private ProductService productService;
  
  @Autowired
  private ReviewService reviewService;

  // @GetMapping("/") //! http://localhost:8080/products/
  @GetMapping //! http://localhost:8080/products
  public String getIndex(Model model, @RequestParam(required = false) String productName) {
    
    List<Product> products = productName == null 
                              ? productService.findAll()
                              // * findByName perché il campo salvato nel db è name (se invece fosse stato title allora findByTitle)
                              : productService.findByName(productName);
  
    model.addAttribute("products", products);  
    
    return "product-index";
  }

  @GetMapping("/{id}")
  public String getShow(@PathVariable int id, Model model){

    // Product product = productService.findById(id).get();
    // oppure
    Product product = productService.findById(id).orElse(null);
    // Se il prodotto non esiste, reindirizza alla pagina principale dei prodotti
    if (product == null) {
      return "redirect:/products";
    }

    // ottenere le recensioni in base all'id del prodotto
    List<Review> reviews = reviewService.getReviewsByProductId(id);

    model.addAttribute("product", product);
    model.addAttribute("reviews", reviews);

    return "product-show";
  }

  





}
