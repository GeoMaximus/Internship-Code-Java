package com.db.command;

import com.db.factory.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Pizza> pizzaList;

    public void addPizza(Pizza pizza){
        pizzaList = new ArrayList<>();
        pizzaList.add(pizza);
    }

    public List<Pizza> placeOrder(){
        System.out.println("Order successfully placed");
        return pizzaList;
    }

    public void removePizza(Pizza pizza){
        pizzaList.remove(pizza);
    }

    public void cancelOrder(){
        if(pizzaList!=null) {
            pizzaList.removeAll(pizzaList);
        }
        else {System.out.println("No order placed");}

        System.out.println("Order successfully canceled");

    }
}
