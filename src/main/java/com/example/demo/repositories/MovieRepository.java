package com.example.demo.repositories;

import com.example.demo.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Page<Movie> findAll(Pageable pageable);
    Page<Movie> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Movie> findAllByCategory(String category, Pageable pageable);

}
