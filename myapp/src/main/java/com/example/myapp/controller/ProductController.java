package com.example.myapp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.myapp.models.Product;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class ProductController {

    @GetMapping("/product")
    public String getProduct(Model model) {
        Product product = new Product(1,"Biscuit",(float) 45.3);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Biscuit",(float) 36.7));
        products.add(new Product(2, "Chocolate",(float) 67.78));
        products.add(new Product(3, "Chips",(float) 90.89));
        model.addAttribute("products", products);
        return "products";
    }
}