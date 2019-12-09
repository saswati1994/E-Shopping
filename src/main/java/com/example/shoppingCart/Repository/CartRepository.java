package com.example.shoppingCart.Repository;

import com.example.shoppingCart.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
