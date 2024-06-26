package com.assessment.repository;

import com.assessment.model.Admin;
import com.assessment.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsernameAndPassword(String username, String password);

    Admin findByUsername(String username);
}
