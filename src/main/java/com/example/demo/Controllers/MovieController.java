package com.example.demo.Controllers;


import com.example.demo.entities.Movie;
import com.example.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieR;


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













}
