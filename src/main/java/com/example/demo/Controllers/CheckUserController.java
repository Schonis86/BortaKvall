package com.example.demo.Controllers;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CheckCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class CheckUserController {

    @Autowired
    private CheckCustomerRepository checkCustomerRepository;


    @GetMapping("/home")
    public String goHome(){
        return "/home/home";
    }

    @PostMapping("/home")
    public String checkUser(@RequestParam String socialNumber, Model model,@ModelAttribute Customer customer) {

        customer = checkCustomerRepository.findById(socialNumber).get();
        System.out.println(customer.getSocialNumber());

        if (customer != null){
            model.addAttribute("customer",customer);

            return "redirect:/rentals/rentalinterface?socialNumber="+socialNumber;
        }
        else {
            return "/home/home";
        }

    }

}
