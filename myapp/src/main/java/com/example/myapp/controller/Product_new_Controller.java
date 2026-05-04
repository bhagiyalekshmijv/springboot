package com.example.myapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.myapp.models.Product_new;
import com.example.myapp.repository.ProductnewRepository;
@Controller
public class Product_new_Controller {
    
    @Autowired
    private ProductnewRepository productRepository;
    
    @GetMapping("/product_new_create")
    public String addcategory(Model model){
        model.addAttribute("message", "Enter the form fields");
        return "product_new";
    }

    @PostMapping("/save_product_new")
    public String savecategory(Product_new product,Model model) {
         
        Product_new n = new Product_new();
        n.setName(product.getName());
        n.setCategory(product.getCategory());    
        productRepository.save(n);
        
        model.addAttribute("message", "The product " + product.getName() +" is saved successfully");
        return "product_new"; 
    }
    
}