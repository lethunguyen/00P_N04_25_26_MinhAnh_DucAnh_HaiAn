package Controller;
import java.util.*;

import Model.Guest;

public class GuestCRUD {
    private List<Guest> guests = new ArrayList<>();

    // CREATE
    public void add(Guest guest) {
        guests.add(guest);
    }

    // READ
    public List<Guest> getAll() {
        return guests;
    }

    // UPDATE
    public void update(String id, String newName, String newPhone, String newAddress) {
        for (Guest g : guests) {
            if (g.getId().equals(id)) {
                g.setName(newName);
                g.setPhone(newPhone);
                g.setAddress(newAddress);
                break;
            }
        }
    }

    // DELETE
    public void delete(String id) {
        guests.removeIf(g -> g.getId().equals(id));
    }
}
