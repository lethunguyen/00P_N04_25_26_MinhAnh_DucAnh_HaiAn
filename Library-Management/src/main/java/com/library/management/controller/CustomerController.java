package Controller;

import src.Database.DatabaseConnection;
import src.Model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    public void addCustomer(Customer c) {
        String sql = "INSERT INTO customers (username, password, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPhone());
            ps.executeUpdate();
            System.out.println("✅ Customer added successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error adding customer: " + e.getMessage());
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Customer c = new Customer(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
                list.add(c);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error retrieving customers: " + e.getMessage());
        }

        return list;
    }

    public void updateCustomer(Customer c) {
        String sql = "UPDATE customers SET username=?, password=?, email=?, phone=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPhone());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
            System.out.println("✅ Customer updated successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error updating customer: " + e.getMessage());
        }
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Customer deleted successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error deleting customer: " + e.getMessage());
        }
    }
}
