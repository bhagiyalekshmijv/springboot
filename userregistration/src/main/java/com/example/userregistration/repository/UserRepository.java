package com.example.userregistration.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userregistration.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}