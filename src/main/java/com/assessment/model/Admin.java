package com.assessment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminid;
    private String username;
    private String password;
    // Getters and setters
}
