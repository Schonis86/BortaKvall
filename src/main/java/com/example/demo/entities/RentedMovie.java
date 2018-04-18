package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "rentedmovie")
public class RentedMovie {

    @EmbeddedId
    private RentedMovieKey rentedMovieKey;
    private LocalDate fromDate;
    private LocalDate toDate;

    public RentedMovie(){

    }

    public RentedMovie(RentedMovieKey rentedMovieKey) {
        this.rentedMovieKey = rentedMovieKey;
        this.fromDate = LocalDate.now();
        this.toDate = null;
    }

    public RentedMovieKey getRentedMovieKey() {
        return rentedMovieKey;
    }

    public void setRentedMovieKey(RentedMovieKey rentedMovieKey) {
        this.rentedMovieKey = rentedMovieKey;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
