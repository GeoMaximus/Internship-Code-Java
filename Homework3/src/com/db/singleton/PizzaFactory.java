package com.db.singleton;

public class PizzaFactory {
    private static PizzaFactory pizzaFactory;

    private PizzaFactory(){

    }

    public synchronized static PizzaFactory getPizzaFactory(){
        if (pizzaFactory == null) {
            pizzaFactory = new PizzaFactory();
        }
        return pizzaFactory;
    }
}
