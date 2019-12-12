package com.example.shoppingCart.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "appearal")
public class Apperal extends  Product{







        @Column(name = "type")
        private String type;

        @Column(name = "brand")
        private String brand;

        @Column(name = "design")
        private String design;
    public Apperal(Long productId,String productName,double price, String type, String brand,String design) {
        super(productId,productName,price);
        this.type = type;
        this.brand = brand;
        this.design = design;
    }

    public Apperal() {
        super();

    }



        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getDesign() {
            return design;
        }

        public void setDesign(String design) {
            this.design = design;
        }
    }


