package com.example.simpleregistration_login.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    private String username;
    private String email;
    private String password;
    private String confirmpassword;
    private String token;

    public User() {
        super();
    }
    
    public User(String username, String email, String password, String confirmpassword) {
    	this.username = username;
    	this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    
    public String getToken() {
    	return token;
    }
    public void setToken(String token) {
    	this.token = token;
    }
}