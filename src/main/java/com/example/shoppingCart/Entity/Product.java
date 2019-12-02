package com.example.shoppingCart.Entity;



import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Cart")
public class Product {

    private Integer productId;
    private float price;
    private String productName;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
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
}
