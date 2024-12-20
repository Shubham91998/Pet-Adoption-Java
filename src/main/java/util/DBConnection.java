package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
    private static final String URL = "jdbc:mysql://localhost:3306/pet_services";
    private static final String USER = "root";
    private static final String PASSWORD = "Shubham845412@";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Failed to establish a database connection!");
            e.printStackTrace();
            return null;
        }
    }

}
