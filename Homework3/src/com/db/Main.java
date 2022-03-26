/*Implement a PizzaFactory that can create the following pizzas: Marguerita, ProsciuttoFunghi, Capriciosa and QuatroStagioni.

        •Make the PizzaFactory a singleton class
        •Implement a decorator that can add topping to each type of pizza
        •Add a Client class and implement an Observer inside PizzaFactory. Allow clients to be notified about new baked pizzas.
        •Add a Command pattern to allow clients to give orders to the PizzaFactory.
        •Test the class in a main method*/


package com.db;

import com.db.command.CancelOrder;
import com.db.command.ExecuteOrder;
import com.db.command.Order;
import com.db.decorator.Barbeque;
import com.db.decorator.Mozzarella;
import com.db.factory.*;
import com.db.observer.Client;
import com.db.observer.Observer;
import com.db.singleton.*;

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
        Pizzeria store = new Pizzeria(pizzaFactory);
        Pizza pizza = store.order("Marguerita");
        Pizza pizza1 = store.order("ProsciuttoFunghi");
        store.order("Capriciosa");
        store.order("QuatroStagioni");


        //BUILDER



        //DECORATOR
        pizza = new Mozzarella(pizza);
        pizza1 = new Barbeque(pizza1);


        //OBSERVER
        Observer o = new Client();
        Observer o1 = new Client();
        Observer o2 = new Client();

        pizzaFactory.addObserver(o);
        pizzaFactory.addObserver(o1);
        pizzaFactory.addObserver(o2);

        pizzaFactory.newPizza(pizza);
        pizzaFactory.newPizza(pizza1);

        //COMMAND
        Order order = new Order();
        order.addPizza(pizza);
        order.addPizza(pizza1);
        order.removePizza(pizza);

        pizzaFactory.setCommand(new ExecuteOrder(order));
        pizzaFactory.confirmCommaand();
        pizzaFactory.setCommand(new CancelOrder(order));
        pizzaFactory.confirmCommaand();




    }
}
