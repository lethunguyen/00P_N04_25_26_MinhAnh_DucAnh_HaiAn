package src.Model;

public class Guest {
    private String name;
    private String id;
    private String phone;
    private String address;

    // Constructor
    public Guest(String name, String id, String phone, String address) {
        try {
            validateData(name, id, phone, address);
            this.name = name;
            this.id = id;
            this.phone = phone;
            this.address = address;
        } catch (InvalidGuestDataException e) {
            System.out.println("⚠️ Error creating Guest: " + e.getMessage());
            this.name = "Unknown";
            this.id = "Unknown";
            this.phone = "Number not provided";
            this.address = "Address not provided";
        }
    }

    // Validation method
    private void validateData(String name, String id, String phone, String address)
            throws InvalidGuestDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidGuestDataException("Name cannot be empty");
        }
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidGuestDataException("ID cannot be empty");
        }
        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidGuestDataException("Phone number cannot be empty");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new InvalidGuestDataException("Address cannot be empty");
        }
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new InvalidGuestDataException("Name cannot be empty");
            }
            this.name = name;
        } catch (InvalidGuestDataException e) {
            System.out.println("⚠️ Error setting name: " + e.getMessage());
        }
    }

    public String getId() { return id; }
    public void setId(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new InvalidGuestDataException("ID cannot be empty");
            }
            this.id = id;
        } catch (InvalidGuestDataException e) {
            System.out.println("⚠️ Error setting ID: " + e.getMessage());
        }
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        try {
            if (phone == null || phone.trim().isEmpty()) {
                throw new InvalidGuestDataException("Phone number cannot be empty");
            }
            this.phone = phone;
        } catch (InvalidGuestDataException e) {
            System.out.println("⚠️ Error setting phone: " + e.getMessage());
        }
    }

    public String getAddress() { return address; }
    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            System.out.println("⚠️ Warning: address is empty, keeping previous value");
            return;
        }
        this.address = address;
    }

    // toString
    @Override
    public String toString() {
        return "Guest {name='" + name + "', id='" + id +
                "', phone='" + phone + "', address='" + address + "'}";
    }

    // Inner Exception class (no separate file needed)
    public static class InvalidGuestDataException extends Exception {
        public InvalidGuestDataException(String message) {
            super(message);
        }
    }
}
