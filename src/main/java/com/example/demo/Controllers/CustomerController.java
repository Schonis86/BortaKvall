package com.example.demo.Controllers;

import com.example.demo.entities.Customer;
import com.example.demo.form.CustomerForm;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerR;

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerR.findAll());
        return "customer/customers";
    }

    @GetMapping("/addcustomer")
    public String openSaveCustomer(CustomerForm customerForm) {
        return "customer/addcustomer";
    }


    @PostMapping("/addcustomer")
    public String saveCustomer(@Valid CustomerForm customerForm, BindingResult bindingResult, @RequestParam String socialNumber, String fName, String lName, String address, String zipCode, String city, String country, String phone, String email) {

        if (bindingResult.hasErrors()) {
            return "customer/addcustomer";
        }
        customerR.save(new Customer(socialNumber, fName, lName, address, zipCode, city, country, phone, email));
        return "redirect:/customer/customers";
    }

    @GetMapping("/lastNameSearch")
    public String titleSearch(Model model, @RequestParam String lName) {
        List<Customer> searchResult = customerR.findAllByLNameContainingIgnoreCase(lName);
        model.addAttribute("customers", searchResult);
        return "/customer/customers";
    }


}
