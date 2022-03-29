package com.demo;

import com.demo.database.Customer;
import com.demo.database.DatabaseWrapper;
import com.demo.database.Order;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        DatabaseWrapper databaseWrapper = new DatabaseWrapper("root", "root");
        Customer c1 = new Customer(1,"da", "da", "da", "da", "da", "da", "da", "da");
        Customer c2 = new Customer(2,"da1", "da", "da", "da", "da", "da", "da", "da");
        Customer c3 = new Customer(3,"dalaksjdgalsfvashfahfhalhdflalhjsfajlhalshh2", "da", "da", "da", "da", "da", "da", "da");
//        databaseWrapper.addCustomer(c1);
//        databaseWrapper.addCustomer(c2);
//        databaseWrapper.addCustomer(c3);
//        databaseWrapper.updateCustomerPhone(1, "0777");
//        Customer customer = databaseWrapper.getCustomerById(1);
//        System.out.println(customer);
//        long miliseconds = System.currentTimeMillis();
//        Order order = new Order(2, new Date(miliseconds), new Date(miliseconds), "Shipped", "Comment");
//        databaseWrapper.addNewOrder(order, c2);
        //Customer c4 = new Customer(4,"dalaksjdakhsdfaskjfgaksjfblasjfalsjhfbalshjfglahsbdflashjjgalsfvashfahfhalhdflalhjsfajlhalshh2", "da", "da", "da", "da", "da", "da", "da");
        //databaseWrapper.addCustomer(c4);
    }
}
