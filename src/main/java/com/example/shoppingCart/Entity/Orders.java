package com.example.shoppingCart.Entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    @Id
    @SequenceGenerator(sequenceName = "order_seq", name = "order_seq_gen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "prod_id")
    private Long productId;

    @Column(name = "quantity")
    private Integer quantity;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @Column(name = "cart_Id")
    private Integer cartId;

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
