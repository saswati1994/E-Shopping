package com.example.shoppingCart.Entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@Table(name = "Cart")
@TypeDef(name = "jsonb",typeClass = JsonBinaryType.class)
public class Cart implements Serializable {
    @Id
    @SequenceGenerator(sequenceName = "cart_seq" , name = "cart_seq_gen" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq_gen")
    @Column(name = "cart_id")
    private  Integer cartId;
    @Column(name = "user_id")
    private Integer userId;


  //@Column(name = "product_list")(mappedBy="cart")
   @OneToMany(mappedBy = "cart")
    private List<Product> products;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

   public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



}
