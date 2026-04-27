package com.example.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class HelloWorldController {

    @GetMapping("/home")
    public String home() {
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        String message = "The beautiful thing about learning is that no one can take it away from you.";
        model.addAttribute("message", message);
        String hello = "<h1>Hello, World!</h1>";
        model.addAttribute("hello", hello);
        boolean isLoggedIn = true;
        model.addAttribute("isLoggedIn", isLoggedIn);
        return "hello";
    }
    
    @GetMapping("/partials")
    public String aboutus() {
        return "index";
    }    
}