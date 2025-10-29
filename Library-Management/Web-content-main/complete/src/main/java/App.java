package src;

import src.Database.DBConnection;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        System.out.println("📘 Library Management System starting...");
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("System ready.");
        } else {
            System.out.println("System failed to start. Check DB configuration.");
        }
    }
}
