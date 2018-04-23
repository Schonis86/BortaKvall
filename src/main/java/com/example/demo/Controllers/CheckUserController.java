package com.example.demo.Controllers;

import com.example.demo.entities.Customer;
import com.example.demo.form.CheckCustomerForm;
import com.example.demo.form.CustomerForm;
import com.example.demo.repositories.CheckCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller

public class CheckUserController {

    @Autowired
    private CheckCustomerRepository checkCustomerRepository;


    @GetMapping("/home")
    public String goHome(CheckCustomerForm checkCustomerForm){
        return "/home/home";
    }

    @PostMapping("/home")
    public String checkUser(@Valid CheckCustomerForm checkCustomerForm, BindingResult bindingResult, @RequestParam String socialNumber, Model model, @ModelAttribute Customer customer) {

        customer = checkCustomerRepository.getOne(socialNumber);


        if (bindingResult.hasErrors()){
            return "/home/home";
        }
        else if (customer != null){
            model.addAttribute("customer",customer);
            return "redirect:/rentals/rentalinterface?socialNumber="+socialNumber;
        }
        else {
            String message = "The customer does not exist ";
            return "/home/home?message="+message;
        }

    }

}
