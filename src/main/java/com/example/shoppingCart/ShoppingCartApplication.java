package com.example.shoppingCart;

import com.example.shoppingCart.Entity.Apperal;
import com.example.shoppingCart.Entity.Book;
import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ShoppingCartApplication.class, args);
		System.out.println("welcome to shoppingcart application");
		//@PersistenceContext(unitName = Product);

	}

}
