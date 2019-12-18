package com.example.shoppingCart.Controller;

import com.example.shoppingCart.Entity.*;
import com.example.shoppingCart.Repository.CartRepository;
import com.example.shoppingCart.Repository.OrderRepository;
import com.example.shoppingCart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    /**
     * dummy implementation to test persistence.
     */
    @PostMapping("/product")
    public void addProducts() {

   Apperal prod2 = new Apperal();
   prod2.setProductName("the dress");
    prod2.setPrice(12.34);
   prod2.setType("stylis");
   prod2.setBrand("me");
 prod2.setDesign("mine");


        Book prod1 = new Book();
        prod1.setPrice(34);
        prod1.setProductName("the computer book");
        prod1.setPublication("mine");
        prod1.setAuthor("me");
        productRepository.save(prod1);
        productRepository.save(prod2);
    }
    @GetMapping("/product")
   /* public List<Product> getAllProducts(){

        return productRepository.findAll();

    }*/
    public List<Cart> getAllProducts(){

        return cartRepository.findAll();

    }
}
