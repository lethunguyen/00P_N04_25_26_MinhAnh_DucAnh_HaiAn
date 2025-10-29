package src.Controller;

import src.Database.DBConnection;
import src.Model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookController {

    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, year, available) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getYear());
            ps.setBoolean(4, book.isAvailable());
            ps.executeUpdate();
            System.out.println("✅ Book added successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error adding book: " + e.getMessage());
        }
    }

    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Book b = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getBoolean("available")
                );
                list.add(b);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error retrieving books: " + e.getMessage());
        }
        return list;
    }

    public void updateBook(Book book) {
        String sql = "UPDATE books SET title=?, author=?, year=?, available=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getYear());
            ps.setBoolean(4, book.isAvailable());
            ps.setInt(5, book.getId());
            ps.executeUpdate();
            System.out.println("✅ Book updated successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error updating book: " + e.getMessage());
        }
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Book deleted successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error deleting book: " + e.getMessage());
        }
    }
}
