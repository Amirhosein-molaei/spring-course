package com.molaei.controllers;

import com.molaei.data.entities.Customer;
import com.molaei.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
@AllArgsConstructor
@Data
public class CustomerRegisterController {

    private CustomerService service;

    @GetMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer){
        return "registerCustomer";
    }

    @PostMapping("/register")
    public String save(@Valid @ModelAttribute("customer") Customer customer , BindingResult result){

        if(result.hasErrors()){
            return "registerCustomer";
        }

        service.addCustomer(customer);
        return "registerCustomerSuccess";
    }
}
