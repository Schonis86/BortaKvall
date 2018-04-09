package com.example.demo.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produktNumber;
    @NotNull
    private String name;
    private String description;
    private String releaseDate;
    @NotNull
    private String category;
    @NotNull
    private String format;
    @NotNull
    private boolean avaliable;
//    private List<Customer> customers;

    public Movie(String name, String description, String releaseDate, String category, String format, boolean avaliable) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.category = category;
        this.format = format;
        this.avaliable = avaliable;
    }

    public Long getProduktNumber() {
        return produktNumber;
    }

    public void setProduktNumber(Long produktNumber) {
        this.produktNumber = produktNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

 /*   public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }*/
}
