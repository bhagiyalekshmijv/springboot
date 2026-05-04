package com.example.restaurant.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class DishController {

	@GetMapping("/dish/{name}/{price}")
	public String showDish(@PathVariable String name, @PathVariable double price, Model model) {
	  
	   model.addAttribute("dishName", name);
	   model.addAttribute("dishPrice", price);
	   return "dish";
	}
}