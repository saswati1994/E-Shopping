package com.example.shoppingCart.Controller;

import com.example.shoppingCart.Entity.AddToCartDTO;
import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Entity.Product;
import com.example.shoppingCart.Repository.CartRepository;
import com.example.shoppingCart.Repository.ProductRepository;
import com.example.shoppingCart.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/shop")
public class ShoppingCartController {
    /* @Autowired
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
     }*/
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/cart")
    public ResponseEntity<Cart> addToCart(@RequestBody AddToCartDTO addToCart) {

        System.out.println("AddToCart POST Called \n" + addToCart);

        Cart cart = new Cart();
        cart.setUserId(addToCart.getUserId());
        cart.setOrders(addToCart.getItems());
        try {
            cartRepository.save(cart);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(cart, HttpStatus.CREATED);
    }
    @GetMapping("/cart")
    public ResponseEntity getCartItems(@RequestParam final Long cartId) {

        Optional<Cart> cart = cartRepository.findById(cartId);
        System.out.println(cart);
        Map resp = new HashMap<>();

        Double totalPrice = 0.00;

        List items = new ArrayList();

        cart.ifPresent(cart1 -> {

            resp.put("cartId", cart1.getCartId());
            resp.put("userId", cart1.getUserId());


            cart.get().getOrders().stream()
                    .forEach(order -> {
                        Product product = productRepository.findById(order.getProductId()).get();
                        Map productDTO = new HashMap<>();
                        productDTO.put("productDesc", product);
                        productDTO.put("quantity", order.getQuantity());
                        items.add(productDTO);

                    });
            resp.put("products", items);


        });

        return new ResponseEntity(resp, HttpStatus.OK);

    }

}