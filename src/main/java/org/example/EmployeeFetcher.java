package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeFetcher {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            String jdbcUrl = "jdbc:mysql://localhost:3306/EmployeeDB";
            String username = "root";
            String password = "admin";
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create a statement to execute SQL queries.
            statement = connection.createStatement();

            // Execute the query to fetch data
            String query = "SELECT * FROM employees";
            resultSet = statement.executeQuery(query);

            // Iterates each data and store the data in result set.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");

                // Print or process the retrieved data
                System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Position: " + position + ", Salary: " + salary);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close all resources.
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
