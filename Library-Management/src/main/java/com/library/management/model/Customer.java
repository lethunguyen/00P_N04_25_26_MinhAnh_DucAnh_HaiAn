package com.library.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer extends User {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;
}
