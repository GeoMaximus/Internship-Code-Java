package com.db;

public class Main {

    public static void main(String[] args) {
	System.out.println("Hello world");
    int Sum = 0;
    for (int i = 0;i<10;i++){
        Sum+=i;
    }

    System.out.println(Sum);

    Car car = new Car();

    Car car1 = new Car(1234589, "Toyota", 220);
    System.out.println(car1.getBrand());
    System.out.println((car1.getSerialNo()));
    System.out.println(car1.getMaxSpeed());

    System.out.println(car1);


    }
}
