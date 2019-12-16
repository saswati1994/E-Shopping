package com.example.shoppingCart.Entity;

import java.util.List;

public class AddToCartDTO {
    private Long userId;

    private List<Orders> items;

    public Long getUserId() {
        return userId;
    }

    public List<Orders> getItems() {
        return items;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setItems(List<Orders> items) {
        this.items = items;
    }
}
