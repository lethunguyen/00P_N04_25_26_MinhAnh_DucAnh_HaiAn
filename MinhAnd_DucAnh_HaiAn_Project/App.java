import java.util.Scanner;

import Controller.GuestCRUD;
import Model.Guest;

import Controller.EmployeeManager;
import Model.Employee;



public class App {
    public static void main(String[] args) {
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
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter address: ");
                    String address = sc.nextLine();

                    Guest g = new Guest(name, id, phone, address);
                    dao.add(g);
                    System.out.println("✅ Guest added!");
                }
                case 2 -> {
                    System.out.println("\n--- GUEST LIST ---");
                    for (Guest g : dao.getAll()) {
                        System.out.println(g);
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    String id = sc.nextLine();
                    System.out.print("New name: ");
                    String newName = sc.nextLine();
                    System.out.print("New phone: ");
                    String newPhone = sc.nextLine();
                    System.out.print("New address: ");
                    String newAddress = sc.nextLine();

                    dao.update(id, newName, newPhone, newAddress);
                    System.out.println("✅ Guest updated!");
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    String id = sc.nextLine();
                    dao.delete(id);
                    System.out.println("✅ Guest deleted!");
                }
                case 5 -> {
                    System.out.println("👋 Exiting program!");
                    sc.close();
                    return;
                }
                default -> System.out.println("❌ Invalid choice!");
            }
        }
    }
}
