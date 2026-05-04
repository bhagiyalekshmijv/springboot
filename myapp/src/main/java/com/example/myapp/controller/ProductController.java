package com.example.myapp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.myapp.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.myapp.models.ProductModel;
import com.example.myapp.models.Product;
@Controller
public class ProductController {

	@GetMapping("/product")
	public String Product(Model model) {
	    model.addAttribute("message", "Enter Your product Details");
	    return "product";
	}
	@Autowired
	private ProductRepository productRepository;
	@PostMapping("/save-product")
	public String Product(ProductModel productData,Model model) {
	    
	    ProductModel n = new ProductModel();
	    n.setName(productData.getName());
	    n.setDescription(productData.getDescription());    
	    n.setPrice(productData.getPrice()); 
	    productRepository.save(n);
	    
	    model.addAttribute("message", "The product " + productData.getName() +" is saved successfully");
	    return "product"; 
	} 
	
	@GetMapping("/products")
	public String showProducts(Model model) {
		 Iterable<ProductModel> productList = productRepository.findAll();
	    model.addAttribute("products", productList);
	    return "products";
	}
	
	@GetMapping("/productname")
	public String productdetails(Model model) {
	    List<Object[]> namesAndPricesList = productRepository.findNamesAndPrices();
	    model.addAttribute("namesAndPrices", namesAndPricesList);
	    return "product-name";
	}
	
	@GetMapping("/products/{name}/{price}")
	public String getProductDetails(@PathVariable String name, @PathVariable Float price, Model model) {
	   Product product= new Product(0, name, price);
	   product.setName(name);
	   product.setPrice(price);
	   model.addAttribute("product", product);
	   return "product-details";
	}

}

