package com.example.simpleregistration_login.controller;

import com.example.simpleregistration_login.models.User;
import com.example.simpleregistration_login.repository.UserRepository;
import com.example.simpleregistration_login.security.TokenGenerator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserAPIController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        // Check empty fields
        if (user.getUsername() == null ||
                user.getEmail() == null ||
                user.getPassword() == null ||
                user.getConfirmpassword() == null) {

            return ResponseEntity.badRequest()
                    .body("All fields are required");
        }

        // Password match validation
        if (!user.getPassword()
                .equals(user.getConfirmpassword())) {

            return ResponseEntity.badRequest()
                    .body("Passwords do not match");
        }

        // Email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {

            return ResponseEntity.badRequest()
                    .body("Email already exists");
        }

        // Encrypt password
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        // Save user
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        // Find user by email
        User dbUser = userRepository.findByEmail(user.getEmail());

        if (dbUser == null) {

            return ResponseEntity.status(401)
                    .body("Invalid Email");
        }

        // Check password
        boolean passwordMatch = passwordEncoder.matches(
                user.getPassword(),
                dbUser.getPassword()
        );

        if (!passwordMatch) {

            return ResponseEntity.status(401)
                    .body("Invalid Password");
        }

        // Generate token
        String token = tokenGenerator.generateToken(
                dbUser.getEmail(),
                dbUser.getPassword()
        );

        // Save token
        dbUser.setToken(token);

        userRepository.save(dbUser);

        // Return token
        return ResponseEntity.ok(
                Map.of(
                        "message", "Login successful",
                        "token", token
                )
        );
    }

    // LOGOUT
    @PostMapping("/logout")
    public ResponseEntity<?> logout(
            @RequestHeader("Authorization") String authHeader) {

        // Check header
        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            return ResponseEntity.status(401)
                    .body("Token missing");
        }

        // Extract token
        String token = authHeader.substring(7);

        // Find user using token
        User user = userRepository.findByToken(token);

        if (user == null) {

            return ResponseEntity.status(401)
                    .body("Invalid token");
        }

        // Remove token
        user.setToken(null);

        userRepository.save(user);

        // Invalidate token
        tokenGenerator.invalidateToken(token);

        return ResponseEntity.ok("Logout successful");
    }
}