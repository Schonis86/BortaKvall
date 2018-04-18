package com.example.demo.repositories;

import com.example.demo.entities.RentedMovie;
import com.example.demo.entities.RentedMovieKey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentedMovieRepository extends CrudRepository<RentedMovie,RentedMovieKey> {
   List<RentedMovie> findByRentedMovieKeySocialNumber(String socialNumber);
}
