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
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Product");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
        Book b = new Book("101","1.1","robert","alb publication");
		Book b1 = new Book("102","1.1","james","xyz publication");
		Apperal a = new Apperal("103","watch","sonata","analog");
		Apperal a1 = new Apperal("104","watch","fossil","digital");

		em.persist(b);
		em.persist(b1);

		em.persist(a);
		em.persist(a1);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
