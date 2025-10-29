package src.Controller;

import src.Model.Guest;
import src.Database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestCRUD {

    public void add(Guest guest) {
        String sql = "INSERT INTO guest (id, name, phone, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, guest.getId());
            stmt.setString(2, guest.getName());
            stmt.setString(3, guest.getPhone());
            stmt.setString(4, guest.getAddress());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("❌ Error adding guest: " + e.getMessage(), e);
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
                        rs.getString("address")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error reading guests: " + e.getMessage(), e);
        }

        return list;
    }

    public void update(String id, String name, String phone, String address) {
        String sql = "UPDATE guest SET name=?, phone=?, address=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, address);
            stmt.setString(4, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("❌ Error updating guest: " + e.getMessage(), e);
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM guest WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("❌ Error deleting guest: " + e.getMessage(), e);
        }
    }
}
