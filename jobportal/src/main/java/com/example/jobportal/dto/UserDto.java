package com.example.jobportal.dto;

public class UserDto {
   
    private String email;
    private String password;
    private String fullname;
    private String mobilenum;
   
    public UserDto(String email, String password, String fullname, String mobilenum) {
        super();
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.mobilenum = mobilenum;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public String getMobilenum() {
        return mobilenum;
    }

    public void setMobilenum(String mobilenum) {
        this.mobilenum = mobilenum;
    }
   
}