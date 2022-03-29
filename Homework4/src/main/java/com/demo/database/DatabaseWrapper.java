package com.demo.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseWrapper {
    String connectionUrl = "jdbc:mysql://localhost:3306/db";
    String username;
    String password;
    Connection connection;

    public DatabaseWrapper(String username, String password) {
        this.username = username;
        this.password = password;
        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ADD A CUSTOMER TO THE TABLE
    public void addCustomer(Customer customer) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into customers values(?,?,?,?,?,?,?,?,?)")) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getUsername());
            preparedStatement.setString(3, customer.getLast_name());
            preparedStatement.setString(4, customer.getFirst_name());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getAddress());
            preparedStatement.setString(7, customer.getCity());
            preparedStatement.setString(8, customer.getPostalCode());
            preparedStatement.setString(9, customer.getCountry());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //GET ALL CUSTOMERS
    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                customer = new Customer(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
                        resultSet.getString(9));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    //GET A CUSTOMER BY SPECIFYING THE ID
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                customer = new Customer(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
                        resultSet.getString(9));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;

    }

    //UPDATE LAST_NAME OF CUSTOMER
    public void updateCustomer(int id, String value){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET last_name = ? WHERE id =?");
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //DELETE A CUSTOMER
    public void deleteCustomer(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //ADD A NEW ORDER TO THE ORDERS TABLE FOR EXISTING CUSTOMER
    public void addNewOrder(Order order, Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into orders values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setDate(2, order.getOrder_date());
            preparedStatement.setDate(3, order.getShipped_date());
            preparedStatement.setString(4, order.getStatus());
            preparedStatement.setString(5, order.getComment());
            preparedStatement.setInt(6, customer.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Viewing all orders for an existing customer
    public List<Order> viewOrdersForCustomer(int id){
        Order order = null;
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE customer_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs =preparedStatement.executeQuery();
            while(rs.next()){
                order = new Order(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5));
                orders.add(order);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    //Update the status of one order (id given as parameter)
    public void updateOrderStatus(String status, int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orders SET status = ? WHERE id = ?");
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }   catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Add comments to one order (id given as parameter)
    public void addOrderComments(String comment, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orders SET comments = ? WHERE id = ?");
            preparedStatement.setString(1, comment);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //When placing an order update the stock for the products
    public void updateStock(OrderDetails orderDetails, Product product){

    }
}
