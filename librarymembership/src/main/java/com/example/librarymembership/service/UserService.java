package com.example.librarymembership.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.librarymembership.dto.UserDto;
import com.example.librarymembership.models.User;
import com.example.librarymembership.repository.UserRepository;

@Service
public class UserService{
   
    @Autowired
    private PasswordEncoder passwordEncoder;
   
    @Autowired
    private UserRepository userRepository;

    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getName() , userDto.getDob() , userDto.getAddress());
        return userRepository.save(user);
    }
}