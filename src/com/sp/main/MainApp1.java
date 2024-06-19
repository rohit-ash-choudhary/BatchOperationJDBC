package com.sp.main;

import java.sql.*;

public class MainApp1 {

    public static void main(String[] args) {
        String driverClass = "com.mysql.cj.jdbc.Driver";
        // Updated JDBC URL with allowPublicKeyRetrieval
        String dbUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true";
        String dbUsername = "root";
        String dbPassword = "Rooh@#2001";
        String sqlQuery1 = "INSERT INTO account VALUES (1, 'Rohit', 'Choudhary', 655646);";
        String sqlQuery2 = "INSERT INTO account VALUES (11, 'Rohrtrtt', 'Chy', 5767576);";
        String sqlSelect = "SELECT * FROM account";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            statement = connection.createStatement();

            // Adding insert queries to the batch
            statement.addBatch(sqlQuery1);
            statement.addBatch(sqlQuery2);
           // statement.addBatch(sqlSelect);

            // Executing the batch
            int[] count = statement.executeBatch();
            for (int i : count) {
                System.out.println(i + " rows affected");
            }

            // Executing the select query separately


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
