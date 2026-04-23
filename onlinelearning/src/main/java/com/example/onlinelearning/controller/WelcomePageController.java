package com.example.onlinelearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class WelcomePageController {

    @GetMapping("/home")
    public String home(Model model) {
        String message = "The beautiful thing about learning is that no one can take it away from you.";
        model.addAttribute("message", message);
        
        String heading = "<h1>Hello from Spring Boot!</h1>";
        model.addAttribute("heading", heading);
        
        boolean isLoggedIn = true;
        model.addAttribute("isLoggedIn", isLoggedIn);
        
        return "WelcomePage";
    }
}