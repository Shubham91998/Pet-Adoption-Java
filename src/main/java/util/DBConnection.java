package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
    private static final String URL = "jdbc:mysql://localhost:3306/pet_services";
    private static final String USER = "root";
    private static final String PASSWORD = "Your Own Password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Optional: Load the MySQL JDBC driver (not always necessary with newer JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Failed to establish a database connection!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
        return connection;
    }
}
