package com.example.demo.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RentedMovieKey implements Serializable {
    private Long productNumber;
    private String socialNumber;

    public RentedMovieKey(Long productNumber, String socialNumber) {
        this.productNumber = productNumber;
        this.socialNumber = socialNumber;
    }

    public RentedMovieKey(){

    }

    public Long getProduktNumber() {
        return productNumber;
    }

    public void setProduktNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }
}
