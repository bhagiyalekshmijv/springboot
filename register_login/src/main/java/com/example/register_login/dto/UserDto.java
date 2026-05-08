package com.example.register_login.dto;

public class UserDto {
   
    private String username;
    private String password;
    private String phonenum;
   
    public UserDto(String username, String password, String phonenum) {
        super();
        this.username = username;
        this.password = password;
        this.phonenum = phonenum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
   
}