package com.example.mobileshop.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.mobileshop.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.mobileshop.models.PhoneModel;
import java.util.List;
@Controller
public class PhoneController {

	@GetMapping("/phone")
	public String Phone(Model model) {
	    model.addAttribute("message", "Enter Your Phone Details");
	    return "phone-form";
	}
	@Autowired
	private PhoneRepository phoneRepository;
	@PostMapping("/save-phone")
	public String Phone(PhoneModel phoneData,Model model) {
	    
	    PhoneModel n = new PhoneModel();
	    n.setName(phoneData.getName());
	    n.setBrand(phoneData.getBrand());    
	    n.setPrice(phoneData.getPrice());
	    n.setType(phoneData.getType());
	    phoneRepository.save(n);
	    
	    model.addAttribute("message", "The product " + phoneData.getName() +" is saved successfully");
	    return "phone-form"; 
	}
	
	@GetMapping("/phones")
	public String phoneDetails(Model model) {
	    List<Object[]> namesAndPrices = phoneRepository.findNamesAndPrices();
	    model.addAttribute("namesAndPrices", namesAndPrices);
	    
	    List<Object[]> cheapPhones = phoneRepository.findCheapPhones();
	    model.addAttribute("cheapPhones", cheapPhones);
	    
	    List<Object[]> typeCount = phoneRepository.countPhonesByType();
	    model.addAttribute("typeCount", typeCount);
	    
	    return "phone-list";
	}

}