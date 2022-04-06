package com.db.singleton;

import com.db.command.Command;
import com.db.factory.*;
import com.db.observer.Observer;

import java.util.ArrayList;

public class PizzaFactory {
    private static PizzaFactory pizzaFactory;
    private ArrayList<Observer> observers;
    public Command command;

    public Pizza createPizza(String type){
        Pizza pizza = null;
        switch (type){
            case "Marguerita": return pizza = new Marguerita();
            case "ProsciuttoFunghi": return pizza = new ProsciuttoFunghi();
            case "Capriciosa": return pizza = new Capriciosa();
            case "QuatroStagioni": return pizza = new QuatroStagioni();
            default: return null;
        }
    }

    private PizzaFactory(){
        observers = new ArrayList<>();
    }

    public synchronized static PizzaFactory getPizzaFactory(){
        if (pizzaFactory == null) {
            pizzaFactory = new PizzaFactory();
        }
        return pizzaFactory;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void newPizza(Pizza pizza){
        System.out.println("New pizza is baked!");
        for(Observer o : observers){
            o.receiveNotification("New pizza!!");
        }
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void confirmCommaand(){
        command.execute();
    }


}
