package com.library.management.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "guests") // khớp schema.sql
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}
