package com.example.demo.Controllers;


import com.example.demo.entities.Movie;
import com.example.demo.entities.RentedMovie;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieR;
    @Autowired
    private RentedMovieRepository rentedMovieR;
    @Autowired
    private CustomerRepository customerR;


    @GetMapping("/movies")
    public String getAllMovies(Model model){
        model.addAttribute("movies", movieR.findAll());
        return "movie/movies";
    }

    @PostMapping("/movies")
    public String saveMovie(@RequestParam boolean avaliable, String category, String description, String format, String imgLink, String name, String releaseDate ){
        movieR.save(new Movie(name, description, releaseDate, category, format, imgLink, avaliable));
        return"redirect:/movie/movies";
    }

    @PostMapping("/deletemovie")
    public String deleteMovie(@RequestParam Long productNumber){
        Movie movie = movieR.getOne(productNumber);
        if (movie.isAvaliable()){
            movieR.deleteById(productNumber);
        }

        return "redirect:/movie/movies";
    }
    @GetMapping("/overduemovies")
    public String overduedMovies(Model model){

        List<RentedMovie> overduedMovies = rentedMovieR.findByToDate(null).stream()

                .filter(om -> om.getRentedMovieKey().getFromDate().isBefore(LocalDateTime.now().minusMinutes(2)))
                .collect(Collectors.toList());
        overduedMovies.forEach(rm -> rm.setCustomer(customerR.getOne(rm.getRentedMovieKey().getSocialNumber())));
        overduedMovies.forEach(rm -> rm.setMovie(movieR.getOne(rm.getRentedMovieKey().getProductNumber())));

        model.addAttribute("overduemovies", overduedMovies);
        return "/movie/overduemovies";
    }













}
