package com.example.shoppingCart.Entity;

import java.util.List;

public class AddToCartDTO {
    private Integer userId;

    private List<Orders> items;

    public Integer getUserId() {
        return userId;
    }

    public List<Orders> getItems() {
        return items;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setItems(List<Orders> items) {
        this.items = items;
    }
}
