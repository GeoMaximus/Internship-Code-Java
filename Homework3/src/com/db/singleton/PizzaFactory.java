package com.db.singleton;

public class PizzaFactory {
    private static PizzaFactory pizzaFactory;

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

    }

    public synchronized static PizzaFactory getPizzaFactory(){
        if (pizzaFactory == null) {
            pizzaFactory = new PizzaFactory();
        }
        return pizzaFactory;
    }

}
