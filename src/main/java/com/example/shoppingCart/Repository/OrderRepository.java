package com.example.shoppingCart.Repository;

import com.example.shoppingCart.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE orders o SET o.quantity = :quantity WHERE o.productId = :productId")
    void updateAddress(@Param("quantity") Integer quantity, @Param("productId") Long productId);
}
