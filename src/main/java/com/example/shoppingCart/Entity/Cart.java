package com.example.shoppingCart.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/*@Entity
@Table(name = "Cart")*/
public class Cart {
    private List<Product> products;
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



}
