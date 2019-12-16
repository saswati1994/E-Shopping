package com.example.shoppingCart.Controller;

import com.example.shoppingCart.Entity.AddToCartDTO;
import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Entity.Orders;
import com.example.shoppingCart.Entity.Product;
import com.example.shoppingCart.Repository.CartRepository;
import com.example.shoppingCart.Repository.OrderRepository;
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

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @PostMapping("/cart")
    public ResponseEntity<Cart> addToCart(@RequestBody AddToCartDTO addToCart) {

        System.out.println("AddToCart POST Called \n" + addToCart);

        Cart cart = new Cart();
        cart.setUserId(addToCart.getUserId());
        cart.setOrders(addToCart.getItems());

        Long user_id = cart.getUserId();
        Optional<Cart> crt = cartRepository.findById(user_id);

        if(crt.isPresent())
            if(crt.get().getUserId() == user_id){


                /*Orders orders = new Orders();
                orders.setOrderId(crt.get().getUserId());*/
                List<Orders> orderss = cart.getOrders();
                List<Orders> orders = crt.get().getOrders();
                for(Orders order:orders){
                    for(Orders order1 :orderss){
                        if(order.getProductId()== order1.getProductId()){
                            //increase quantity
                            Integer quantity = order.getQuantity();
                            quantity = quantity + order1.getQuantity();//payload quantity
                            order.setQuantity(quantity);
                            //save order entity
                            try {
                                orderRepository.save(order);
                            }catch(Exception e){
                                e.printStackTrace();
                            }

                        }  else{
                            //save order entity
                            try {
                                orderRepository.save(order);
                            }catch(Exception e) {
                                e.printStackTrace();

                            }
                        }
                    }

                }


            }else{
                try {
                    cartRepository.save(cart);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
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