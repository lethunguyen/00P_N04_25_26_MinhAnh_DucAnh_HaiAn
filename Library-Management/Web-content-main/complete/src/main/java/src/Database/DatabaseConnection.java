package src.Database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Dotenv dotenv = Dotenv.load();

                String url = dotenv.get("DB_URL");
                String user = dotenv.get("DB_USER");
                String password = dotenv.get("DB_PASSWORD");

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);

                System.out.println("✅ Đã kết nối MySQL (qua .env)!");
            } catch (ClassNotFoundException e) {
                System.out.println("❌ Không tìm thấy driver MySQL!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("❌ Lỗi khi kết nối MySQL!");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("🔒 Đã đóng kết nối MySQL!");
            } catch (SQLException e) {
                System.out.println("⚠️ Lỗi khi đóng kết nối!");
                e.printStackTrace();
            }
        }
    }
}
