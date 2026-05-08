package com.example.register_login.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.register_login.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}