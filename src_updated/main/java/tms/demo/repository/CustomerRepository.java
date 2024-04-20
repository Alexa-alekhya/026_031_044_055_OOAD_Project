package tms.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import tms.demo.model.Customer;

@Repository
public class CustomerRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/tms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aditi031078";

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String username = rs.getString("username");
                String idType = rs.getString("id_type");
                String number = rs.getString("number");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String country = rs.getString("country");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                Customer customer = new Customer(username, idType, number, name, gender, country, address, phone,
                        email);
                customer.setId(id);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }

        return customers;
    }

    public void save(Customer customer) {
        String sql = "INSERT INTO customers (username, id_type, number, name, gender, country, address, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getIdType());
            stmt.setString(3, customer.getNumber());
            stmt.setString(4, customer.getName());
            stmt.setString(5, customer.getGender());
            stmt.setString(6, customer.getCountry());
            stmt.setString(7, customer.getAddress());
            stmt.setString(8, customer.getPhone());
            stmt.setString(9, customer.getEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    // Other methods for update, findById, etc., can be implemented similarly
}
