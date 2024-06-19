package com.sp.main;

import java.sql.*;

public class MainApp2 {
    public static void main(String[] args) {
        String driverClass = "com.mysql.cj.jdbc.Driver";
        // Updated JDBC URL with allowPublicKeyRetrieval
        String dbUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true";
        String dbUsername = "root";
        String dbPassword = "Rooh@#2001";
        String sqlQuery1 = "INSERT INTO account VALUES (?,?,?,?);";
        String sqlQuery2 = "INSERT INTO account VALUES (?,?,?,?);";
        String sqlSelect = "SELECT * FROM account";

        Connection connection = null;
        PreparedStatement pt = null;


        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            pt = connection.prepareStatement(sqlQuery1 );

            pt.setInt(1,100);
            pt.setString(2,"Karan");
            pt.setString(3, "Aujhla");
            pt.setInt(4, 5000);
            pt.addBatch();

            pt.setInt(1,1011);
            pt.setString(2,"Jassi");
            pt.setString(3, ",GAILL");
            pt.setInt(4, 4540);
            pt.addBatch();

            // Adding insert queries to the batch

            // statement.addBatch(sqlSelect);

            // Executing the batch
            int[] count = pt.executeBatch();
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

                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
