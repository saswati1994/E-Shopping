package com.example.shoppingCart.Service;

import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    com.example.shoppingCart.Repository.CartRepository cartRepository;
    public void addProducts(final Cart cart){
        cartRepository.save(cart);
    }
}
