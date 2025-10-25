package src.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }

        try {
            // Load environment variables
            Dotenv dotenv = Dotenv.configure()
                .directory("./") // path tới file .env
                .ignoreIfMissing()
                .load();

            String url = dotenv.get("DB_URL");
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            if (url == null || user == null || password == null) {
                throw new RuntimeException("⚠️ Missing DB configuration in .env file!");
            }

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to database successfully!");
        } catch (SQLException e) {
            throw new RuntimeException("❌ Database connection failed: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("❌ Unexpected error while connecting to DB: " + e.getMessage(), e);
        }

        return connection;
    }
}
