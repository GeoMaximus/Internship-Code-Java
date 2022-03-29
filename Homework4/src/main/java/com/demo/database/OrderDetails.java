package com.demo.database;

public class OrderDetails {
    private int id;
    private String product_code;
    private int quantity;
    private double priceEach;

    public OrderDetails(int id, String product_code, int quantity, double priceEach) {
        this.id = id;
        this.product_code = product_code;
        this.quantity = quantity;
        this.priceEach = priceEach;
    }

    public int getId() { return id; }

    public String getProduct_code() { return product_code; }

    public int getQuantity() { return quantity; }

    public double getPriceEach() { return priceEach; }
}
