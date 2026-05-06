package com.example.jobportal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobportal.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}