package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import util.DBConnection;

public class UserDAOImpl implements UserDAO {

    // Register a new user in the database
    @Override
    public boolean registerUser(User user) {
        String query = "INSERT INTO users (username, email, password, phone_number, address) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = DBConnection.getConnection()) {
            if (con == null) {
                System.err.println("Database connection failed!");
                return false;
            }
            
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getAddress());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    // Validate login credentials
    @Override
    public boolean validateLogin(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        
        try (Connection con = DBConnection.getConnection(); 
             PreparedStatement stmt = con.prepareStatement(query)) {
            
        	stmt.setString(1, email);
        	stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            return rs.next();  // If user exists, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
} 