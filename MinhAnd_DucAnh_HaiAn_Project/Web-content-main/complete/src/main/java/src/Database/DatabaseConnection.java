package src.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //private static final String HOST = ; //thay host trong aiven vào ""
    private static final int PORT = 26835;
    private static final String DATABASE = "defaultdb";
    private static final String USER = "avnadmin";
    //private static final String PASSWORD = ; // ⚠️ Thay mật khẩu thật của bạn tại đây ""

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        try {
            String url = String.format(
                "jdbc:mysql://%s:%d/%s?sslMode=REQUIRED",
                HOST, PORT, DATABASE
            );
            connection = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("✅ Database connected successfully!");
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("🔌 Database connection closed.");
            } catch (SQLException e) {
                System.err.println("⚠️ Failed to close database: " + e.getMessage());
            }
        }
    }
}
