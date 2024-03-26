package com.assessment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Entity
@Table(name = "admin")
public class Admin implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminid;


    @Column(unique = true) // Ensure no duplicate usernames
    private String username;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }


    // True because no lock unlock for now
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // True because no lock unlock for now
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    // True because not implemented
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    // True because not implemented
    @Override
    public boolean isEnabled() {
        return true;
    }
}
