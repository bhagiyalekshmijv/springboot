package com.example.schoolproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class ProjectAppController {

    @GetMapping("/project")
    public String home() {
        return "home";
    }
    
    @GetMapping("/product")
    public String product() {
        return "product";
    }
    
    @GetMapping("/projectapp")
    public String project() {
        return "ProjectApp";
    }
}