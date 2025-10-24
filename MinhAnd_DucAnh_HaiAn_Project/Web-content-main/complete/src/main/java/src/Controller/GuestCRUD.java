package src.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import src.Model.Guest;
import src.Database.DatabaseConnection;

public class GuestCRUD {

    public GuestCRUD() {
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS guest (" +
                "id VARCHAR(50) PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "phone VARCHAR(20)," +
                "address VARCHAR(200)" +
                ")";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Table 'guest' is ready.");
        } catch (SQLException e) {
            System.err.println("⚠️ Failed to create table: " + e.getMessage());
        }
    }

    public void add(Guest g) {
        String sql = "INSERT INTO guest (id, name, phone, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, g.getId());
            ps.setString(2, g.getName());
            ps.setString(3, g.getPhone());
            ps.setString(4, g.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Error adding guest: " + e.getMessage());
        }
    }

    public List<Guest> getAll() {
        List<Guest> list = new ArrayList<>();
        String sql = "SELECT * FROM guest";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Guest(
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getString("phone"),
                        rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            System.err.println("⚠️ Error fetching guests: " + e.getMessage());
        }
        return list;
    }

    public void update(String id, String name, String phone, String address) {
        String sql = "UPDATE guest SET name=?, phone=?, address=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("⚠️ Error updating guest: " + e.getMessage());
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM guest WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("⚠️ Error deleting guest: " + e.getMessage());
        }
    }
}
