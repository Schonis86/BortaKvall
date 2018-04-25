package com.example.demo.Controllers;


import com.example.demo.entities.Movie;
import com.example.demo.entities.RentedMovie;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.MovieRepository;
import com.example.demo.repositories.RentedMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRep;
    @Autowired
    private RentedMovieRepository rentedMovieR;
    @Autowired
    private CustomerRepository customerR;

    private int pages = 0;

  /*  @GetMapping("/movies")
    public String getAllMovies( Model model, Pageable pageable) {
        Page<Movie> page = movieRep.findAll(pageable);
        model.addAttribute("movies",page.getTotalElements());
        return "movie/movies";
    }*/


    @GetMapping("/movies")
    public String getAllMovies(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("movies", movieRep.findAll(PageRequest.of(page, 10)));
        model.addAttribute("next", page + 1);
        model.addAttribute("prev", page - 1);
        return "/movie/movies";
    }

    @PostMapping("/movies")
    public String saveMovie(@RequestParam boolean avaliable, String category, String description, String format, String imgLink, String name, String releaseDate) {
        movieRep.save(new Movie(name, description, releaseDate, category, format, imgLink, avaliable));
        return "redirect:/movie/movies";
    }

    @PostMapping("/deletemovie")
    public String deleteMovie(@RequestParam Long productNumber) {
        Movie movie = movieRep.getOne(productNumber);
        if (movie.isAvaliable()) {
            movieRep.deleteById(productNumber);
        }

        return "redirect:/movie/movies";
    }

    @GetMapping("/overduemovies")
    public String overduedMovies(Model model) {

        List<RentedMovie> overduedMovies = rentedMovieR.findByToDate(null).stream()

                .filter(om -> om.getRentedMovieKey().getFromDate().isBefore(LocalDateTime.now().minusMinutes(2)))
                .collect(Collectors.toList());
        overduedMovies.forEach(rm -> rm.setCustomer(customerR.getOne(rm.getRentedMovieKey().getSocialNumber())));
        overduedMovies.forEach(rm -> rm.setMovie(movieRep.getOne(rm.getRentedMovieKey().getProductNumber())));

        model.addAttribute("overduemovies", overduedMovies);
        return "/movie/overduemovies";
    }


    @GetMapping("/titleSearch")
    public String titleSearch(Model model, @RequestParam String name, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("movies", movieRep.findAllByNameContainingIgnoreCase(name, PageRequest.of(page, 5)));
        return "/movie/movies";
    }

    @GetMapping("/categorysearch")
    public String categorySearch(Model model, @RequestParam String category, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("movies", movieRep.findAllByCategory(category, PageRequest.of(page, 5)));
        return "/movie/movies";
    }

}
