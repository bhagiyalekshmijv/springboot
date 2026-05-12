package com.example.simpleregistration_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.simpleregistration_login.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByToken(String token);
    boolean existsByToken(String token);
}