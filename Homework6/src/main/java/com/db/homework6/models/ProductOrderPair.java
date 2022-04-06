package com.db.homework6.models;

public class ProductOrderPair {
    private String product;
    private String order;

    public String getCustomer() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
