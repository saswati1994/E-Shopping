package com.example.shoppingCart.Repository;

import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("SELECT cartId from Cart where userId = :userId")
    public Long getCartId(@Param("userId") Long userId);
}
