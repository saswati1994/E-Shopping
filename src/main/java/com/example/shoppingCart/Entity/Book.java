package com.example.shoppingCart.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends Product{




    @Column(name = "genre")
    private String genere;

    @Column(name = "author")
    private String author;

    @Column(name = "publication")
    private String publication;
    public Book(Long productId, String productName,double price,String genere, String author,String publication) {
        super(productId,productName,price);
        this.genere = genere;
        this.author = author;
        this.publication = publication;
    }

    public Book() {
        super();

    }

    public String getGenere() {
        return genere;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublication() {
        return publication;
    }
    public void setPublication(String publication) {
        this.publication = publication;
    }



}








