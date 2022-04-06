package com.db.homework6.model;

public class OrderDetails {
    private int id;
    private String product_code;
    private int quantity;
    private double priceEach;

    public OrderDetails() {}

    public OrderDetails(int id, String product_code, int quantity, double priceEach) {
        this.id = id;
        this.product_code = product_code;
        this.quantity = quantity;
        this.priceEach = priceEach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }
}
