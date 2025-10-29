package src.Database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // single-ton Connection
    private static Connection connection = null;

    // Lấy thông tin từ .env (Dotenv sẽ đọc file .env ở project root)
    private static String getEnv(String key) {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing() // tránh ném nếu .env không tồn tại (dùng fallback)
                .load();
        return dotenv.get(key);
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }

        try {
            String url = getEnv("DB_URL");
            String user = getEnv("DB_USER");
            String pass = getEnv("DB_PASSWORD");

            // fallback mặc định (chỉ dùng khi .env không có) — an toàn cho dev
            if (url == null || url.isEmpty()) {
                url = "jdbc:mysql://localhost:3306/librarydb";
            }
            if (user == null) {
                user = "root";
            }
            if (pass == null) {
                pass = "";
            }

            // đảm bảo driver được load (JDBC 4+ tự load, nhưng gọi rõ ràng không hại)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ignored) {
                // nếu không tìm thấy driver thì DriverManager sẽ ném SQLException sau đó
            }

            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ DatabaseConnection: connected to DB (" + url + ")");
            return connection;

        } catch (SQLException e) {
            // ném runtime để các lớp phía trên có thể xử lý và in thông báo rõ ràng
            throw new RuntimeException("❌ DatabaseConnection: failed to connect - " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("❌ DatabaseConnection: unexpected error - " + e.getMessage(), e);
        }
    }

    public static void closeConnection() {
        if (connection == null) return;
        try {
            connection.close();
            connection = null;
            System.out.println("🔒 DatabaseConnection: connection closed");
        } catch (SQLException e) {
            System.err.println("⚠️ DatabaseConnection: error closing connection - " + e.getMessage());
        }
    }
}
