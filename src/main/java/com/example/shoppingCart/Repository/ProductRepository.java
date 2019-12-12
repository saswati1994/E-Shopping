package com.example.shoppingCart.Repository;
import com.example.shoppingCart.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long>  {
}
