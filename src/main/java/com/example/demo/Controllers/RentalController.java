package com.example.demo.Controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Movie;
import com.example.demo.entities.RentedMovie;
import com.example.demo.entities.RentedMovieKey;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.MovieRepository;
import com.example.demo.repositories.RentedMovieRepository;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
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


        List<RentedMovie> rentedMovies = rentedMovieRep.findByRentedMovieKeySocialNumber(socialNumber);
        rentedMovies.forEach(rm -> rm.setCustomer(customerRep.getOne(rm.getRentedMovieKey().getSocialNumber())));
        rentedMovies.forEach(rm -> rm.setMovie(movieRep.getOne(rm.getRentedMovieKey().getProductNumber())));
        Collections.reverse(rentedMovies);

        model.addAttribute("rentedMovies", rentedMovies);
        model.addAttribute("customer", customerRep.getOne(socialNumber));

        return "rentals/rentalinterface";
    }

    @PostMapping("/rentalinterface")
    public String rentalPost(@RequestParam Long productNumber, @RequestParam String socialNumber) {
        System.out.println(productNumber);
       Movie movie = movieRep.getOne(productNumber);

        if (movie.isAvaliable()) {
            System.out.println("is movies här?");
            rentedMovieRep.save(new RentedMovie(new RentedMovieKey(productNumber, socialNumber, LocalDateTime.now())));
            movie.setAvaliable(false);
            movieRep.save(movie);

        } else {
            System.out.println("FEEEEEEEEEEEEEEL");
        }
        return "redirect:/rentals/rentalinterface?socialNumber="+socialNumber;
    }

    @PostMapping("/rentals/returnRentedMovie")
    public String returnMovie(@RequestParam Long productNumber, @RequestParam String socialNumber, @RequestParam String fromDate){
        RentedMovie rMovie = rentedMovieRep.getOne(new RentedMovieKey(productNumber, socialNumber, LocalDateTime.parse(fromDate)));
        Movie movie = movieRep.getOne(productNumber);

        if(rMovie != null) {
            rMovie.setToDate(LocalDate.now());
            rentedMovieRep.save(rMovie);
            movie.setAvaliable(true);
            movieRep.save(movie);
        }
        else {
            System.out.println("Nånting annat feeeeeeel");
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
