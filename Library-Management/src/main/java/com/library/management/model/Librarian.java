package com.library.management.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "librarians")
public class Librarian extends User {

    private String fullName;
    private String citizenId;
    private int age;

    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL)
    private List<BorrowRequest> handledRequests;

    public String getFullName() { return fullName; }
    public String getCitizenId() { return citizenId; }
    public int getAge() { return age; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setCitizenId(String citizenId) { this.citizenId = citizenId; }
    public void setAge(int age) { this.age = age; }
}
