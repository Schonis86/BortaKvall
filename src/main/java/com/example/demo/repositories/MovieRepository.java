package com.example.demo.repositories;

import com.example.demo.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
