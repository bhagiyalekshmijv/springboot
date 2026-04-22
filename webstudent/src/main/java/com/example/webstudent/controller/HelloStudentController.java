package com.example.webstudent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class HelloStudentController {

    @GetMapping("/student")
    public String hello() {
        return "HelloStudent";
    }
}