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

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //create buses
        Bus b1 = new Bus();
        Bus b2 = new Bus("red", true, 20, 14.5f);
        Bus b3 = new Bus("yellow", false, 30, 3.2f);


        //create taxis
        Taxi t1 = new Taxi();
        Taxi t2 = new Taxi("black", true, 3, 35.5f);
        Taxi t3 = new Taxi("yellow", false, 2, 20.4f);


        //create the list and populate it
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(b1);
        vehicleList.add(b2);
        vehicleList.add(b3);
        vehicleList.add(t1);
        vehicleList.add(t2);
        vehicleList.add(t3);


        //initalize the busStation
        BusStation busStation = new BusStation(vehicleList);


        //testing getters and setters
        System.out.println("Bus 1 info: ");
        System.out.println(b1.getColour());
        System.out.println(b1.isFunctional());

        b1.setColour("another one");
        b1.setFunctional(true);

        System.out.println("Bus 1 info after using setters: ");
        System.out.println(b1.getColour());
        System.out.println(b1.isFunctional());

        System.out.println("----------------------");

        //testing the abstract methods
        System.out.println("Abstract methods for bus B2:");
        System.out.println("Bus2 charge is: " + b2.charge());
        System.out.println("Bus2 profit is: " + b2.profit());
        b2.display();

        System.out.println("Abstract methods for bus T3:");
        System.out.println("Taxi3 charge is: " + t3.charge());
        System.out.println("Taxi3 charge is: " + t3.profit());
        t3.display();

        Vehicle b4 = new Bus("maroon", true, 15, 4.3f);
//        System.out.println(b4 instanceof Vehicle);
//        System.out.println(b4 instanceof Bus);
//        System.out.println(b4 instanceof Taxi);
        System.out.println("Abstract methods for bus B4:");
        System.out.println("Bus4 charge is: " + b4.charge());
        System.out.println("Bus4 profit is: " + b4.profit());
        b4.display();


        System.out.println("Testing compareTo method");
        //testing compareTo
        if(b2.compareTo(b3) == 1) {
            System.out.println("First bus has more profit" + "Vehicle1: " + b2.profit() + "and Vehicle2: " + b3.profit());
        }
        else if( b2.compareTo(b3) == -1){
            System.out.println("Second bus has more profit" + "Vehicle1: " + b2.profit() + "and Vehicle2: " + b3.profit());
        }
        else
            System.out.println("They have equal profit" + "Bus1: " + "Vehicle1: " + b2.profit() + "and Vehicle2: " + b3.profit());

        System.out.println("----------Displaying all vehicles------------");

        //testing the methods for busStation

        busStation.showAllVehicles();

        System.out.println("------------Displaying total profit----------");

        System.out.println(busStation.showTotalProfit());

        System.out.println("----------Displaying the sorted list based on profit------------");

        for(Vehicle v : busStation.sortVehicles()){
            v.display();
        }









    }
}
