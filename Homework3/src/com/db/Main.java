/*Implement a PizzaFactory that can create the following pizzas: Marguerita, ProsciuttoFunghi, Capriciosa and QuatroStagioni.

        •Make the PizzaFactory a singleton class
        •Implement a decorator that can add topping to each type of pizza
        •Add a Client class and implement an Observer inside PizzaFactory. Allow clients to be notified about new baked pizzas.
        •Add a Command pattern to allow clients to give orders to the PizzaFactory.
        •Test the class in a main method*/


package com.db;

import com.db.singleton.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //SINGLETON
        PizzaFactory pizzaFactory = PizzaFactory.getPizzaFactory();
        PizzaFactory pizzaFactory1 = PizzaFactory.getPizzaFactory();
        PizzaFactory pizzaFactory2 = PizzaFactory.getPizzaFactory();

        System.out.println(pizzaFactory == pizzaFactory1);
        System.out.println(pizzaFactory2 == pizzaFactory1);
        System.out.println(pizzaFactory == pizzaFactory1);

        //FACTORY
        Pizza pizza = new Marguerita();
        Pizza pizza1 = new QuatroStagioni();
        Pizza pizza2 = new Capriciosa();
        Pizza pizza3 = new ProsciuttoFunghi();

        //BUILDER



        //DECORATOR
        pizza2 = new Tomatoes(pizza2);
        pizza3 = new Mozzarella(pizza3);


        //OBSERVER


        //COMMAND

    }
}
