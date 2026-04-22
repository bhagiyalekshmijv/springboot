package com.example.createphotography.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class WelcomeController {

    @GetMapping("/start")
    public String home() {
        return "redirect:/welcome";
    }
    
    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }
}