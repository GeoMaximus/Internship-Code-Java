package com.db.decorator;

import com.db.factory.Pizza;

public class Mozzarella extends Decorator{

    Pizza pizza;
    public Mozzarella(Pizza pizza){
        this.pizza = pizza;
        System.out.println("Added mozzarella");
    }

}
