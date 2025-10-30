package Controller;

import src.Database.DatabaseConnection;
import src.Model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    public void add(Employee employee) {
        String sql = "INSERT INTO employee (id, name, role, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getRole());
            stmt.setDouble(4, employee.getSalary());

            stmt.executeUpdate();
            System.out.println("✅ Employee added: " + employee.getName());

        } catch (SQLException e) {
            throw new RuntimeException("❌ Error adding employee: " + e.getMessage(), e);
        }
    }

    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getDouble("salary")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("❌ Error reading employees: " + e.getMessage(), e);
        }

        return employees;
    }

    public void update(String id, String name, String role, double salary) {
        String sql = "UPDATE employee SET name=?, role=?, salary=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setDouble(3, salary);
            stmt.setString(4, id);

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                System.out.println("⚠️ No employee found with id: " + id);
            } else {
                System.out.println("✅ Employee updated: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("❌ Error updating employee: " + e.getMessage(), e);
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM employee WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            int rows = stmt.executeUpdate();

            if (rows == 0) {
                System.out.println("⚠️ No employee found with id: " + id);
            } else {
                System.out.println("🗑️ Employee deleted: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("❌ Error deleting employee: " + e.getMessage(), e);
        }
    }
}
