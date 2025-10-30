package Model;

public class Customer extends User {
    private String email;
    private String phone;

    public Customer() {}

    public Customer(int id, String username, String password, String email, String phone) {
        super(id, username, password, "customer");
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + getUsername() + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
