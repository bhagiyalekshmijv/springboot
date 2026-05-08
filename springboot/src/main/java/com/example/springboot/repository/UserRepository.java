package com.example.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}