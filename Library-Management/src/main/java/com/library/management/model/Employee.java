package com.library.management.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees") // Khớp với schema.sql
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {

    private String role; // "librarian", "admin", ...
}
