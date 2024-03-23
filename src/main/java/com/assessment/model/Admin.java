package com.assessment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminid;

    @Column(unique = true) // Ensure no duplicate usernames
    private String username;
    private String password;
    // Getters and setters
}
