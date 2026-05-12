package com.example.userregistration_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.userregistration_login.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByToken(String token);
    boolean existsByToken(String token);
}