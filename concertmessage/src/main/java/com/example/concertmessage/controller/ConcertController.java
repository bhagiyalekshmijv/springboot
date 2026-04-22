package com.example.concertmessage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class ConcertController {

    @GetMapping("/concert")
    public String concert() {
        return "Concert";
    }
}