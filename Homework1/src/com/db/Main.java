/*
Create a Vehicle class [that implements Comparable interface].
        Requirements:
        •Vehicle has the following properties: colour (String) and functional (boolean)
        •An empty constructor that sets default values, and one with parameters
        •Getters and setters for the field (encapsulate the properties)
        •Three abstract methods:charge, profit and display(optional)
        •Implement the compareTo method that compares two vehicles by their profit (optional)
        Create two classes that extend Vehicle class: Bus and Taxi, with two new fields:noPassengers, ticketPrice.
        •Define constructors for the two classes
        •Calculate profit as 25% of the price for each charge.
        •Create a BusStation class that holds an array of Vehicles. Create three methods: showAllVehicles, showTotalProfit, [sortVehicles].
        •Test the methods in a main class by populating the array with various vehicles.
*/

package com.db;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bus b1 = new Bus();
        Bus b2 = new Bus("red", true, 20, 14.5f);
        Bus b3 = new Bus("yellow", false, 30, 3.2f);

        Taxi t1 = new Taxi();
        Taxi t2 = new Taxi("black", true, 3, 35.5f);
        Taxi t3 = new Taxi("yellow", false, 2, 20.4f);

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(b1);
        vehicleList.add(b2);
        vehicleList.add(b3);
        vehicleList.add(t1);
        vehicleList.add(t2);
        vehicleList.add(t3);

        BusStation busStation = new BusStation(vehicleList);

        System.out.println(b1.getColour());
        System.out.println(b1.isFunctional());

        b1.setColour("another one");
        b1.setFunctional(true);

        System.out.println(b1.getColour());
        System.out.println(b1.isFunctional());

        System.out.println("----------------------");

        System.out.println("For bus B2:");
        System.out.println(b2.charge());
        System.out.println(b2.profit());
        b2.display();

        System.out.println("For bus B3:");
        System.out.println(b3.charge());
        System.out.println(b3.profit());
        b3.display();

        if(b2.compareTo(b3) == 1) {
            System.out.println("First bus has more profit");
        }
        else if( b2.compareTo(b3) == -1){
            System.out.println("Second bus has more profit");
        }
        else
            System.out.println("They have equal profit");

        System.out.println("----------------------");

        busStation.showAllVehicles();

        System.out.println("----------------------");

        System.out.println(busStation.showTotalProfit());

        System.out.println("----------------------");

        for(Vehicle v : busStation.sortVehicles()){
            v.display();
        }









    }
}
