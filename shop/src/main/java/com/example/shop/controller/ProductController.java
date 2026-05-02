package com.example.shop.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.shop.models.Product; 
@Controller
public class ProductController {

	@GetMapping("/product")
	public String Product(Model model) {
	    model.addAttribute("message", "Enter Your product Details");
	    return "product-form";
	}
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/save-product")
	public String Product(Product productData,Model model) {
	    
	    Product n = new Product();
	    n.setName(productData.getName());
	    n.setDescription(productData.getDescription());    
	    n.setPrice(productData.getPrice()); 
	    productRepository.save(n);
	    
	    model.addAttribute("message", "The product " + productData.getName() +" is saved successfully");
	    return "product-form"; 
	}
	
	@GetMapping("/products")
	public String showProducts(Model model) {
		 Iterable<Product> productList = productRepository.findAll();
	    model.addAttribute("products", productList);
	    return "product-list";
	}

}