package com.example.springbootrestapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootrestapi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}