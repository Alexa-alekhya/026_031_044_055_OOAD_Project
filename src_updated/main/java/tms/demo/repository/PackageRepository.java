package tms.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import tms.demo.model.Package;

@Repository
public class PackageRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/tms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aditi031078";

    public List<Package> getAllPackages() {
        List<Package> packages = new ArrayList<>();
        String sql = "SELECT * FROM Packages";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String packageName = rs.getString("package_name");
                double price = rs.getDouble("price");

                Package pkg = new Package(id, packageName, price);
                packages.add(pkg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }

        return packages;
    }
}
