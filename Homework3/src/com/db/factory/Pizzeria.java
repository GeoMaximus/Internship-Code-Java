package com.db.factory;

import com.db.singleton.PizzaFactory;

public class Pizzeria {
    PizzaFactory factory;

    public Pizzeria(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza order(String type){
        Pizza pizza;
        pizza = factory.createPizza(type);
        return pizza;
    }
}
