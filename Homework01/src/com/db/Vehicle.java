package com.db;

public abstract class Vehicle implements Comparable<Vehicle> {
    private String colour;
    private boolean functional;

    public Vehicle(){
        this.colour = "black";
        this.functional = false;
    }

    public Vehicle(String colour, boolean functional) {
        this.colour = colour;
        this.functional = functional;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        if(colour.length() > 2) {
            this.colour = colour;
        }
    }

    public boolean isFunctional() {
        return functional;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    public abstract float charge();
    public abstract float profit();
    public abstract void display();

    @Override
    public int compareTo(Vehicle o) {
        if(this.profit() > o.profit()){
            return 1;
        }
        else if(this.profit() == o.profit()){
            return 0;
        }
        else
            return -1;
    }
}
