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
    @SequenceGenerator(name="cart_seq_generator", sequenceName = "cart_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq_generator")
    @Column(name = "cart_id", unique = true)

    private Long cartId;


    @Column(name = "user_id")
    private Long userId;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private List<Orders> orders;

    public Long getCartId() {
        return cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
