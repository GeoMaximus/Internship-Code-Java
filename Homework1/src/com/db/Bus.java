package com.db;

public class Bus extends Vehicle{
    private int noPassengers;
    private float ticketPrice;

    public Bus() {
        this.noPassengers = 0;
        this.ticketPrice = 0f;
    }

    public Bus(String colour, boolean functional, int noPassengers, float ticketPrice) {
        super(colour, functional);
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    public int getNoPassengers() {
        return noPassengers;
    }

    public void setNoPassengers(int noPassengers) {
        if(noPassengers >= 0 && noPassengers < 35) {
            this.noPassengers = noPassengers;
        }
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        if(ticketPrice > 0) {
            this.ticketPrice = ticketPrice;
        }
    }

    @Override
    public float charge() {
        return this.noPassengers * this.ticketPrice;
    }

    @Override
    public float profit() {
        return (float) (charge() * 0.25);
    }

    @Override
    public void display() {
        System.out.println("Bus info: " + this.getColour() + " " + this.noPassengers + " " + this.ticketPrice + " profit is: " + profit() );

    }
}
