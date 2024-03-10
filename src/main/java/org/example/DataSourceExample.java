package org.example;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;


public class DataSourceExample {
    public static void main(String[] args) {
        // Create a DataSource object
        BasicDataSource dataSource = new BasicDataSource();

        // Set DataSource properties
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/EmployeeDB");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setInitialSize(5);           //Set Initial connection pool size.
        dataSource.setMaxTotal(10);             //Set Maximum connection pool size.

        // Use DataSource to get a Connection
        try (Connection connection = dataSource.getConnection()) {
            // Execute SQL queries
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM employees;")) {
                // Process the ResultSet
                while (resultSet.next()) {
                    // Retrieve data from the result set
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String department = resultSet.getString("department");
                    String position = resultSet.getString("position");
                    double salary = resultSet.getDouble("salary");
                    // Process data...
                    System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Position: " + position + ", Salary: " + salary);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
