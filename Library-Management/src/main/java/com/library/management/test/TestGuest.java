package Test;
import src.Controller.GuestCRUD;
import src.Model.Guest;
public class TestGuest {
    public static void main(String[] args) {
        GuestCRUD dao = new GuestCRUD();

        // Add guests
        dao.add(new Guest("An", "G01", "0123456789", "Hanoi"));
        dao.add(new Guest("Binh", "G02", "0987654321", "Danang"));

        // Print all
        System.out.println("Guest list:");
        for (Guest g : dao.getAll()) {
            System.out.println(g);
        }

        // Update
        dao.update("G01", "An Updated", "0909999999", "HCM");

        // Delete
        dao.delete("G02");

        System.out.println("After update & delete:");
        for (Guest g : dao.getAll()) {
            System.out.println(g);
        }
    }
}
