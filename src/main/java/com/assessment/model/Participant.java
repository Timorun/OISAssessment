package com.assessment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @NotBlank(message = "Name is required") // Ensures entry is not null and that it contains at least one non-whitespace character.
    private String name;

    @Column(unique = true) // Ensure no duplicate emails
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format") // Ensures entry is in email format
    private String email;

    // @Column specification because in sql database phoneNumber column name is "phone_number"
    @Column(name = "phone_number")
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;


    // Getters and setters
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}