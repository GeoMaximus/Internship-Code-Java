package com.db;

public class Car {
    public int serialNo;
    public String brand;
    public double maxSpeed;

    public Car(){
        this.serialNo = 0;
        this.brand ="";
        this.maxSpeed = 0;
    }

    public Car(int serialNo, String brand, double maxSpeed) {
        this.serialNo = serialNo;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serialNo=" + serialNo +
                ", brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
