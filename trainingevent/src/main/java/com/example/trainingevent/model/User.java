package com.example.trainingevent.model;
import com.example.trainingevent.GmailOnly;
import com.example.trainingevent.Address;
import jakarta.validation.constraints.NotBlank;

public class User {

    @NotBlank(message = "Name cannot be empty")
    private String name;
    
    @GmailOnly
    private String email;
    
    @Address
    private String address;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
    	this.address=address;
    }
}