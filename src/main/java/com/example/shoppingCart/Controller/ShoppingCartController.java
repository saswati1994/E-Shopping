package com.example.shoppingCart.Controller;

import com.example.shoppingCart.Entity.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShoppingCartController {
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

    @PostMapping("/cart/{userid}")
    public ResponseEntity<Cart> addCartDetails(@RequestBody final Cart cart, @PathVariable final Integer userid) {
        //call service() to add product to cart
        System.out.println(userid);
        System.out.println(cart);
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }
}