package com.abdulrahman.spring_mvc_validation.controller;

import com.abdulrahman.spring_mvc_validation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // trim all strings in every request
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/customerForm")
    public String showForm(Model model){

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult){

        System.out.println("last name: "+"|"+customer.getLastName()+"|");
        if (bindingResult.hasErrors()){
            return "customer-form";
        }
        return "process-form";
    }

    
}
