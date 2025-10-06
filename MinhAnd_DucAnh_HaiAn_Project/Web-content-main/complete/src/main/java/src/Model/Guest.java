package Model;
public class Guest {
    private String name;
    private String id;
    private String phone;
    private String address;

    // Constructor
    public Guest(String name, String id, String phone, String address) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
    }

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    // toString
    @Override
    public String toString() {
        return "Guest {name='" + name + "', id='" + id +
                "', phone='" + phone + "', address='" + address + "'}";
    }
}
