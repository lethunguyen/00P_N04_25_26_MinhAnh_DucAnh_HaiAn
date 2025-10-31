package com.library.management.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends User {

    private String email;
    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<BorrowRequest> borrowRequests;

    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
}
