package com.example.userpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @GetMapping("/submit")
    public String submitForm(@RequestParam("username") String username, Model model) {

        model.addAttribute("username", username);
        model.addAttribute("fullData", "username:" + username);

        return "result";
    }
}