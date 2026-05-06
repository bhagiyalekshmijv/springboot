package com.example.librarymembership.dto;

public class UserDto {
   
    private String email;
    private String password;
    private String name;
    private String dob;
    private String address;
   
    public UserDto(String email, String password, String name, String dob, String address) {
        super();
        this.email = email;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   
}