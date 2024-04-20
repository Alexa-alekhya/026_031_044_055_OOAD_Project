package tms.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tms.demo.model.User;

public class UserRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/tms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aditi031078";

    public void saveUser(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    // Add other CRUD methods as needed
}
