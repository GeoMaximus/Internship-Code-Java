package com.demo.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseWrapper  {
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

    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
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

    public void updateCustomerPhone(int id, String phone) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET PHONE = ? where id = ?");
            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int id, String column, String value){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET ? = ? WHERE id =?");
            preparedStatement.setString(1, column);
            preparedStatement.setString(2, value);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
