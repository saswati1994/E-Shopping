package com.example.shoppingCart.Entity;



import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "prod_type")
public class Product implements Serializable {

 @Id
 @SequenceGenerator(name="prod_seq_generator", sequenceName = "prod_seq", allocationSize = 1)
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq_generator")
 @Column(name = "product_id", unique = true)
 private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private double price;


    public Product(){

    }

    public Product(Long productId, String productName, double price) {
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
