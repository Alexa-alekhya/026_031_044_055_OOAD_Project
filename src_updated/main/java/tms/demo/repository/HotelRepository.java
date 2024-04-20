package tms.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import tms.demo.model.Hotel;

@Repository
public class HotelRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/tms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aditi031078";

    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotels";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String costPerDay = rs.getString("cost_per_day");
                String foodCharges = rs.getString("food_charges");
                String acCharges = rs.getString("ac_charges");

                Hotel hotel = new Hotel(name, costPerDay, foodCharges, acCharges);
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }

        return hotels;
    }
}
