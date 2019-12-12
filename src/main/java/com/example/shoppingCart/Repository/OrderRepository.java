package com.example.shoppingCart.Repository;

import com.example.shoppingCart.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
