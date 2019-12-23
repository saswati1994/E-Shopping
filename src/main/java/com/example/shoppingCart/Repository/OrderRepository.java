package com.example.shoppingCart.Repository;

import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Orders o SET o.quantity = :quantity WHERE o.productId = :productId and o.cartId =:cartId")
    void updateAddress(@Param("quantity") Integer quantity, @Param("productId") Long productId,@Param("cartId") Long cartId);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Orders o SET o.quantity = :quantity WHERE o.productId = :productId")
    void updateQuantity(@Param("quantity") Integer quantity, @Param("productId") Long productId);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Orders o where o.productId=:productId")
   public  void deleteProduct(@Param("productId") Long productId);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("select o from Orders o where o.cartId=:cartId")
    public List<Orders> getOrder(@Param("cartId") Long cartId);
}
