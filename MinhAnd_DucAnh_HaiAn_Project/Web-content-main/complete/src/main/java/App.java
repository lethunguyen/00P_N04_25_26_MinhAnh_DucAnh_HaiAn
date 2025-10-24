import java.util.Scanner;
import java.sql.Connection;

import src.Controller.GuestCRUD;
import src.Model.Guest;
import src.Database.DatabaseConnection;

public class App {
    public static void main(String[] args) {
        Connection testConn = DatabaseConnection.getConnection();
        if (testConn == null) {
            System.err.println("❌ Cannot continue, database not connected!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        GuestCRUD dao = new GuestCRUD();

        while (true) {
            System.out.println("\n===== GUEST MANAGEMENT =====");
            System.out.println("1. Add guest");
            System.out.println("2. View all guests");
            System.out.println("3. Update guest");
            System.out.println("4. Delete guest");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter address: ");
                    String address = sc.nextLine();
                    dao.add(new Guest(name, id, phone, address));
                    System.out.println("✅ Guest added!");
                    break;
                case 2:
                    System.out.println("\n--- GUEST LIST ---");
                    for (Guest g : dao.getAll()) {
                        System.out.println(g);
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    id = sc.nextLine();
                    System.out.print("New name: ");
                    name = sc.nextLine();
                    System.out.print("New phone: ");
                    phone = sc.nextLine();
                    System.out.print("New address: ");
                    address = sc.nextLine();
                    dao.update(id, name, phone, address);
                    System.out.println("✅ Guest updated!");
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextLine();
                    dao.delete(id);
                    System.out.println("✅ Guest deleted!");
                    break;
                case 5:
                    DatabaseConnection.closeConnection();
                    System.out.println("👋 Exiting program!");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
