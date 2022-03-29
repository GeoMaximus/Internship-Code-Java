package com.demo.database;

public class Product {
    private String code;
    private String name;
    private String description;
    private int stock;
    private double price;

    public Product(String code, String name, String description, int stock, double price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public String getCode() { return code; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public int getStock() { return stock; }

    public double getPrice() { return price; }
}
