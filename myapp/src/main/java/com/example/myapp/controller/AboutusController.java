package com.example.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class AboutusController {

    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }
}