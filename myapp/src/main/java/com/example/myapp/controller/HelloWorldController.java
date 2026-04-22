package com.example.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class HelloWorldController {

    @GetMapping("/home")
    public String home() {
        return "redirect:/hello";
    }//generate a redirect response to the URL "/hello"
	
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
}