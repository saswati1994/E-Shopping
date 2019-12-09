package com.example.shoppingCart.Entity;



import javax.persistence.*;


@Entity
@Table(name = "Product")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Product {
    @Id
    private String productId;
    @Column(name = "price")
    private float price;
    @Column(name ="product_name")
    private String productName;
    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
    public Product(){}

    public Product(String productId, float price, String productName, Cart c){
        super();
        this.productId=productId;
        this.price=price;
        this.productName=productName;
        this.cart=c;
    }

    public Product(String productId) {
        this.productId=productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", price=" + price +
                ", productName=" + productName +
                ", cartId='" + cart + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Cart getCart() {
        return cart;
    }



    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
