package com.example.demo.Controllers;

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
        model.addAttribute("rentedMovies", rentedMovieRep.findByRentedMovieKeySocialNumber(socialNumber));
        model.addAttribute("customer",customerRep.findById(socialNumber).get());
        return "rentals/rentalinterface";
    }


    @PostMapping("/rentalinterface")
    public void rentalPost(@RequestParam Long productNumber, String socialNumber) {
        System.out.println(productNumber);
       Movie movie = movieRep.findById(productNumber).get();

        if (movie.isAvaliable()) {
            System.out.println("is movies här?");
            rentedMovieRep.save(new RentedMovie(new RentedMovieKey(productNumber, socialNumber)));
            movie.setAvaliable(false);
        } else {
            System.out.println("FEEEEEEEEEEEEEEL");
        }

    }
}
