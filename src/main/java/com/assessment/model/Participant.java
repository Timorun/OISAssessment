package com.assessment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String name;
    private String email;

    // @Column specification because in sql database phoneNumber column name is "phone_number"
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    // Getters and setters
}