package com.example.demo.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RentedMovieKey implements Serializable {
    private Long produktNumber;
    private String socialNumber;

    public RentedMovieKey(Long produktNumber, String socialNumber) {
        this.produktNumber = produktNumber;
        this.socialNumber = socialNumber;
    }

    public Long getProduktNumber() {
        return produktNumber;
    }

    public void setProduktNumber(Long produktNumber) {
        this.produktNumber = produktNumber;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }
}
