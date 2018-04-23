package com.example.demo.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Embeddable
public class RentedMovieKey implements Serializable {

    private Long productNumber;

    private String socialNumber;
    private LocalDateTime fromDate;

    public RentedMovieKey(Long productNumber, String socialNumber, LocalDateTime fromDate) {
        this.productNumber = productNumber;
        this.socialNumber = socialNumber;
        this.fromDate = fromDate;
    }

    public RentedMovieKey(){

    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }


    public String formatDate(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ");

        return this.fromDate.format(formatter);

    }
}
