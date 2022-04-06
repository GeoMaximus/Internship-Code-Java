package com.db.decorator;

import com.db.factory.Pizza;

public class Barbeque extends Decorator {

    Pizza pizza;
    public Barbeque(Pizza pizza){
        this.pizza = pizza;
        System.out.println("Added barbeque");
    }

}
