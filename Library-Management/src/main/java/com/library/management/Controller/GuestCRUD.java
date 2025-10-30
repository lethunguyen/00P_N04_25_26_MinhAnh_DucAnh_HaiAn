package Controller;

import src.Database.DatabaseConnection;
import src.Model.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestCRUD {

    public void addGuest(Guest guest) {
        String sql = "INSERT INTO guests (id, name, phone, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, guest.getId());
            stmt.setString(2, guest.getName());
            stmt.setString(3, guest.getPhone());
            stmt.setString(4, guest.getAddress());
            stmt.executeUpdate();

            System.out.println("✅ Guest added successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error adding guest: " + e.getMessage());
        }
    }

    public List<Guest> getAllGuests() {
        List<Guest> list = new ArrayList<>();
        String sql = "SELECT * FROM guests";

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
            System.err.println("❌ Error retrieving guests: " + e.getMessage());
        }

        return list;
    }

    public void updateGuest(Guest guest) {
        String sql = "UPDATE guests SET name=?, phone=?, address=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, guest.getName());
            stmt.setString(2, guest.getPhone());
            stmt.setString(3, guest.getAddress());
            stmt.setString(4, guest.getId());
            stmt.executeUpdate();

            System.out.println("✅ Guest updated successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error updating guest: " + e.getMessage());
        }
    }

    public void deleteGuest(String id) {
        String sql = "DELETE FROM guests WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

            System.out.println("✅ Guest deleted successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error deleting guest: " + e.getMessage());
        }
    }
}
