package com.db.singleton;

public class Pizza {

    private Pizza(){

    }

    public Pizza createPizza(String type){
        switch (type){
            case "Marguerita": return new Marguerita();
            case "ProsciuttoFunghi": return new ProsciuttoFunghi();
            case "Capriciosa": return new Capriciosa();
            case "QuatroStagioni": return new QuatroStagioni();
            default: return null;
        }
    }
}
