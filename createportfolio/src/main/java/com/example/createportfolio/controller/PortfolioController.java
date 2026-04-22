package com.example.createportfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class PortfolioController {

    @GetMapping("/start")
    public String home() {
        return "redirect:/portfolio";
    }
    
    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }
}