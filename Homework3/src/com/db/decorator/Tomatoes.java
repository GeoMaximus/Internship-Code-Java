package com.db.decorator;

import com.db.factory.Pizza;

public class Tomatoes extends Decorator{

    Pizza pizza;
    public Tomatoes(Pizza pizza){
        this.pizza = pizza;
        System.out.println("Added tomatoes to");
    }

}
