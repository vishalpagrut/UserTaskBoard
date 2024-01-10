package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    public static Connection getConnection() throws SQLException {
        // Provide your database connection details
        String url = "jdbc:postgresql://localhost:3306/Ascend";
        String username = "yourusername";
        String password = "yourpassword";

        return DriverManager.getConnection(url, username, password);
    }
}
