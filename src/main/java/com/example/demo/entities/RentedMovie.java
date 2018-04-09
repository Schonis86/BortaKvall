package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "rentedmovie")
public class RentedMovie {

    @EmbeddedId
    private RentedMovieKey rentedMovieKey;
    private Date fromDate;
    private Date toDate;

    public RentedMovie(){

    }

    public RentedMovie(RentedMovieKey rentedMovieKey, Date fromDate, Date toDate) {
        this.rentedMovieKey = rentedMovieKey;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public RentedMovieKey getRentedMovieKey() {
        return rentedMovieKey;
    }

    public void setRentedMovieKey(RentedMovieKey rentedMovieKey) {
        this.rentedMovieKey = rentedMovieKey;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
