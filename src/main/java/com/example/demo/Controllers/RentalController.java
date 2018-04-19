package com.example.demo.Controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Movie;
import com.example.demo.entities.RentedMovie;
import com.example.demo.entities.RentedMovieKey;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.MovieRepository;
import com.example.demo.repositories.RentedMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    RentedMovieRepository rentedMovieRep;
    @Autowired
    CustomerRepository customerRep;
    @Autowired
    MovieRepository movieRep;


    @GetMapping("/rentalinterface")
    public String rentalsStart(Model model, @RequestParam String socialNumber) {
        System.out.println("nånting");

        List<RentedMovie> movies = rentedMovieRep.findByRentedMovieKeySocialNumber(socialNumber);
        List<Long> prodNumbers = movies.stream()
                .map(m -> m.getRentedMovieKey().getProductNumber())
                .collect(Collectors.toList());

        model.addAttribute("rentedMovies", rentedMovieRep.findByRentedMovieKeySocialNumber(socialNumber));
        model.addAttribute("customer",customerRep.findById(socialNumber).get());
        model.addAttribute("movies", movieRep.findAllById(prodNumbers));
       // model.addAttribute("movies", movieRep.findAllById(rentedMovieRep.find));
        return "rentals/rentalinterface";
    }

    @PostMapping("/rentalinterface")
    public String rentalPost(@RequestParam Long productNumber, @RequestParam String socialNumber) {
        System.out.println(productNumber);
       Movie movie = movieRep.findById(productNumber).get();

        if (movie.isAvaliable()) {
            System.out.println("is movies här?");
            rentedMovieRep.save(new RentedMovie(new RentedMovieKey(productNumber, socialNumber)));
            movie.setAvaliable(false);

        } else {
            System.out.println("FEEEEEEEEEEEEEEL");
        }
        return "redirect:/rentals/rentalinterface?socialNumber="+socialNumber;
    }

    @PostMapping("/rentals/changecustomer")
    public String changeCustomer(@RequestParam String socialNumber, String fName, String lName, String address, String zipCode, String city, String country, String phone, String email) {
        System.out.println("vafaaaaaaan");
        Customer customer = customerRep.getOne(socialNumber);
        if (fName != "") {
            customer.setfName(fName);
        }
        if (lName != "") {
            customer.setlName(lName);
        }
        if (address != "") {
            customer.setAddress(address);
        }
        if (zipCode != ""){
            customer.setZipCode(zipCode);
        }
        if (city != ""){
            customer.setCity(city);
        }
        if (country != ""){
            customer.setCountry(country);
        }
        if (phone != ""){
            customer.setPhone(phone);
        }
        if (email != ""){
            customer.setEmail(email);
        }
        customerRep.save(customer);
        return "redirect:/rentals/rentalinterface?socialNumber="+socialNumber;
    }


}
