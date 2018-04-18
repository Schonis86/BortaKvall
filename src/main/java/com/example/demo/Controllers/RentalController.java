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
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RentalController {

    @Autowired
    RentedMovieRepository rentedMovieRep;
    @Autowired
    CustomerRepository customerRep;
    @Autowired
    MovieRepository movieRep;


    @GetMapping("rentals/rentalinterface")
    public String rentalsStart(Model model, String socialNumber) {
        model.addAttribute("rentedMovies", rentedMovieRep.findByRentedMovieKeySocialNumber(socialNumber));

        return "rentals/rentalinterface";
    }


    @PostMapping("rentals/rentalinterface")
    public String rentalPost(@RequestParam Long productNumber, String socialNumber, Movie movie) {
        if (movie.isAvaliable()) {
            System.out.println("is movies här?");
            rentedMovieRep.save(new RentedMovie(new RentedMovieKey(productNumber, socialNumber)));
            movie = movieRep.findById(productNumber).get();
            movie.setAvaliable(false);
        } else {
            System.out.println("FEEEEEEEEEEEEEEL");
        }
        return "redirect:/rentals/rentalinterface";
    }
}
