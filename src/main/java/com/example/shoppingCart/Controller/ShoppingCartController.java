package com.example.shoppingCart.Controller;

import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @GetMapping("/cart/{userid}")
    public ResponseEntity<Cart> getCartDetails(@PathVariable final Integer userid) {
        System.out.println("Get cart of user: "+userid);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/cart/{userid}")
    public ResponseEntity<String> removeCartDetails() {
        //call dao to delete product from cart
        return new ResponseEntity<>("product deleted from cart", HttpStatus.OK);
    }

    @PostMapping("/cart")
    public ResponseEntity<String> addCartDetails(@RequestBody final Cart cart) {
        //call service() to add product to cart
        shoppingCartService.addProducts(cart);
        return new ResponseEntity<>("product inserted to cart", HttpStatus.OK);
    }
}