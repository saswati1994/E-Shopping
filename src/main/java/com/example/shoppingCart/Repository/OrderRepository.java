package com.example.shoppingCart.Repository;

import com.example.shoppingCart.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Orders o SET o.quantity = :quantity WHERE o.productId = :productId")
    void updateAddress(@Param("quantity") Integer quantity, @Param("productId") Long productId);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("insert into Orders  (orderId,productId,quantity) select :orderId,:productId,:quantity from Orders")
    public void insertOrders(@Param("orderId") Long orderId,@Param("productId") Long productId,@Param("quantity") Integer quantity);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Orders o where o.productId=:productId")
   public  void deleteProduct(@Param("productId") Long productId);
}
