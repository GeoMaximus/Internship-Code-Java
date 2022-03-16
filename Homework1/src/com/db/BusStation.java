package com.db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusStation {
    List<Vehicle> vehicleList = new ArrayList<>();

    public BusStation(List<Vehicle> vehicleList) {
        for(Vehicle v : vehicleList){
            this.vehicleList = vehicleList;
        }
    }

    public void showAllVehicles(){
        for(Vehicle v : vehicleList)
            v.display();
    }

    public float showTotalProfit(){
        float Sum = 0;
        for(Vehicle v : vehicleList) {
            Sum += v.profit();
        }
        return Sum;
    }

    public List<Vehicle> sortVehicles(){
        return vehicleList.stream().sorted().collect(Collectors.toList());
    }

}
