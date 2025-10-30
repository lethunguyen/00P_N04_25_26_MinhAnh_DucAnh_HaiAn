package Database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Không nên tái sử dụng 1 connection duy nhất (sẽ lỗi khi multi-thread)
    // => chỉ giữ 1 instance Dotenv thay vì 1 connection
    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    private DatabaseConnection() {
        // private constructor để ngăn khởi tạo
    }

    public static Connection getConnection() {
        try {
            String url = getEnv("DB_URL", "jdbc:mysql://localhost:3306/librarydb");
            String user = getEnv("DB_USER", "root");
            String pass = getEnv("DB_PASSWORD", "");

            // Nếu đang test (Spring profile = test hoặc hệ thống có H2)
            if (System.getProperty("spring.profiles.active", "").equals("test")) {
                url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=MySQL";
                user = "sa";
                pass = "";
                Class.forName("org.h2.Driver");
            } else {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }

            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Connected to DB (" + url + ")");
            return conn;

        } catch (Exception e) {
            throw new RuntimeException("❌ DatabaseConnection error: " + e.getMessage(), e);
        }
    }


    private static String getEnv(String key, String fallback) {
        String value = dotenv.get(key);
        return (value != null && !value.isEmpty()) ? value : fallback;
    }

    public static void closeConnection(Connection conn) {
        if (conn == null) return;
        try {
            conn.close();
            System.out.println("🔒 DatabaseConnection: Connection closed");
        } catch (SQLException e) {
            System.err.println("⚠️ DatabaseConnection: Error closing connection - " + e.getMessage());
        }
    }
}
