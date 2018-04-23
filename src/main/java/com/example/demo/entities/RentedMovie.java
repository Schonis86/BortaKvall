package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "rentedmovie")
public class RentedMovie {

    @EmbeddedId
    private RentedMovieKey rentedMovieKey;

    private LocalDate toDate;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Movie movie;

    public RentedMovie(){

    }

    public RentedMovie(RentedMovieKey rentedMovieKey) {
        this.rentedMovieKey = rentedMovieKey;
        this.toDate = null;
    }

    public RentedMovieKey getRentedMovieKey() {
        return rentedMovieKey;
    }

    public void setRentedMovieKey(RentedMovieKey rentedMovieKey) {
        this.rentedMovieKey = rentedMovieKey;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
