package Database;

import java.io.IOException;
import java.nio.file.*;
import java.sql.*;

public class DBInitializer {

    public static void initDatabase() {
        String sqlPath = "src/Database/schema.sql";

        try {
            String sql = new String(Files.readAllBytes(Paths.get(sqlPath)));
            String[] statements = sql.split(";");

            try (Connection conn = DatabaseConnection.getConnection();
                 Statement stmt = conn.createStatement()) {

                for (String command : statements) {
                    String trimmed = command.trim();
                    if (!trimmed.isEmpty()) {
                        try {
                            stmt.execute(trimmed);
                        } catch (SQLException e) {
                            System.err.println("⚠️ SQL skipped: " + trimmed);
                            System.err.println("    Reason: " + e.getMessage());
                        }
                    }
                }
            }

            System.out.println("✅ Database schema initialized successfully from " + sqlPath);

        } catch (IOException e) {
            System.err.println("❌ Error reading SQL file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ SQL execution error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Unexpected error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("🚀 Initializing Library Database...");
        initDatabase();
    }
}
