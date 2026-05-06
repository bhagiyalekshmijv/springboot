package com.example.myapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}