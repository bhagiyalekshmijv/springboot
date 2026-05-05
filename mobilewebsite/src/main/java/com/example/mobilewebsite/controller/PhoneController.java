package com.example.mobilewebsite.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.repository.query.Param;
import com.example.mobilewebsite.models.PhoneModel;
import com.example.mobilewebsite.repository.PhoneRepository;

@Controller
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/create")
    public String createAction(Model model) {
        model.addAttribute("message", "Enter The Product Details");
        return "create";
    }

    @PostMapping("/create")
    public String createActionProcess(PhoneModel phoneData, Model model) {
        phoneRepository.save(phoneData);
        model.addAttribute("message", "The Phone " + phoneData.getName() + " has been added successfully");
        return "create";
    }

    @GetMapping("/all")
    public String getAllPhones(Model model, @Param("keyword") String keyword) {
        List<PhoneModel> phones;
        if (keyword != null && !keyword.isEmpty()) {
            phones = phoneRepository.findAllByKeyword(keyword);
        } else {
            phones = phoneRepository.findAll();
        }
        model.addAttribute("phones", phones);
        return "list";
    }

    @GetMapping("/update/{id}")
    public String updatePhone(@PathVariable Integer id, Model model) {
        Optional<PhoneModel> optionalPhoneDetails = phoneRepository.findById(id);
        if (optionalPhoneDetails.isPresent()) {
            model.addAttribute("phoneDetails", optionalPhoneDetails.get());
            return "update";
        }
        return "redirect:/all"; // Handle not found case
    }

    @PostMapping("/update/{id}")
    public String updatePhone(@PathVariable Integer id, PhoneModel phoneData) {
        Optional<PhoneModel> optionalPhoneDetails = phoneRepository.findById(id);
        if (optionalPhoneDetails.isPresent()) {
            PhoneModel phoneDetails = optionalPhoneDetails.get();
            phoneDetails.setName(phoneData.getName());
            phoneDetails.setDescription(phoneData.getDescription());
            phoneDetails.setPrice(phoneData.getPrice());
            phoneRepository.save(phoneDetails);
        }
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deletePhone(@PathVariable Integer id, Model model) {
        Optional<PhoneModel> optionalPhoneDetails = phoneRepository.findById(id);
        if (optionalPhoneDetails.isPresent()) {
            model.addAttribute("phoneDetails", optionalPhoneDetails.get());
            return "delete";
        }
        return "redirect:/all"; // Handle not found case
    }

    @PostMapping("/delete/{id}")
    public String deletePhone(@PathVariable Integer id) {
    	phoneRepository.deleteById(id);
        return "redirect:/all";
    }
}