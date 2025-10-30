package Controller;

import src.Database.DatabaseConnection;
import src.Model.BorrowRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowRequestController {

    public void createRequest(BorrowRequest req) {
        String sql = "INSERT INTO borrow_requests (customer_id, book_id, status, request_date, return_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, req.getCustomerId());
            ps.setInt(2, req.getBookId());
            ps.setString(3, req.getStatus());
            ps.setDate(4, Date.valueOf(req.getRequestDate()));
            ps.setDate(5, Date.valueOf(req.getReturnDate()));
            ps.executeUpdate();
            System.out.println("✅ Borrow request created!");

        } catch (SQLException e) {
            System.err.println("❌ Error creating borrow request: " + e.getMessage());
        }
    }

    public List<BorrowRequest> getAllRequests() {
        List<BorrowRequest> list = new ArrayList<>();
        String sql = "SELECT * FROM borrow_requests";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                BorrowRequest req = new BorrowRequest(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getInt("book_id"),
                        rs.getString("status"),
                        rs.getDate("request_date").toLocalDate(),
                        rs.getDate("return_date").toLocalDate()
                );
                list.add(req);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error retrieving borrow requests: " + e.getMessage());
        }
        return list;
    }

    public void updateRequestStatus(int id, String status) {
        String sql = "UPDATE borrow_requests SET status=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("✅ Request status updated!");

        } catch (SQLException e) {
            System.err.println("❌ Error updating request: " + e.getMessage());
        }
    }

    public void deleteRequest(int id) {
        String sql = "DELETE FROM borrow_requests WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Request deleted!");

        } catch (SQLException e) {
            System.err.println("❌ Error deleting request: " + e.getMessage());
        }
    }
}
