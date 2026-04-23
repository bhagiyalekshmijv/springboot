package com.example.moviewebsite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class MovieController {

    @GetMapping("/movie")
    public String showMovie(Model model) {
    
        String preview = "A thief who steals corporate secrets....";
        model.addAttribute("preview", preview);
        
        String title = "<h1>Inception</h1>";
        model.addAttribute("title", title);
        
        boolean isLoggedIn = true;
        model.addAttribute("isLoggedIn", isLoggedIn);
        
        return "movie";
    }
}