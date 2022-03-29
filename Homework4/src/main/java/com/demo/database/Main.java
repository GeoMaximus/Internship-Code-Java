package com.demo.database;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseWrapper databaseWrapper = new DatabaseWrapper("root", "parola");
        Customer c1 = new Customer(1,"da", "da", "da", "da", "da", "da", "da", "da");
        Customer c2 = new Customer(2,"da1", "da", "da", "da", "da", "da", "da", "da");
        Customer c3 = new Customer(3,"dal", "da", "da", "da", "da", "da", "da", "da");

//        databaseWrapper.addCustomer(c1);
//        databaseWrapper.addCustomer(c2);
//        databaseWrapper.addCustomer(c3);
//        Customer customer = databaseWrapper.getCustomerById(1);
//        System.out.println(customer);
//        long miliseconds = System.currentTimeMillis();
//        Order order = new Order(2, new Date(miliseconds), new Date(miliseconds), "Shipped", "Comment");
//        databaseWrapper.addNewOrder(order, c2);

        List<Customer> customerList = databaseWrapper.getCustomers();
        for(Customer c : customerList) {
            System.out.println(c);
        }

//      databaseWrapper.updateCustomer(2, "gigel");

//        databaseWrapper.deleteCustomer(3);
//        databaseWrapper.deleteCustomer(2);

        Order order1 = new Order(6, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), "active", "no comments");
//        databaseWrapper.addOrder(order1, 2);

        List<Order> orders = databaseWrapper.viewOrdersForCustomer(2);
        for(Order o : orders){
            System.out.println(o);
        }

        //databaseWrapper.updateOrderStatus("incative", 1);

        //databaseWrapper.addOrderComments("another comment", 1);

        Product product = new Product("Prod5", "Prod1", "Description", 120, 12.34);
        OrderDetails orderDetails = new OrderDetails(6, "Product1", 10, 5.5);
        databaseWrapper.updateStock(orderDetails, product);
    }
}
