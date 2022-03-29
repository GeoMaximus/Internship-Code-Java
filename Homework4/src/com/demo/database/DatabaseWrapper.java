package com.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
