package com.db.singleton;

public class Tomatoes extends Decorator{

    Pizza pizza;
    public Tomatoes(Pizza pizza){
        this.pizza = pizza;
        System.out.println("Added tomatoes");
    }

}
