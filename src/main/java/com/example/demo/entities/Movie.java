package com.example.demo.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {



    private Long productNumber;
    private String name;
    private String description;
    private String releaseDate;
    private String category;
    private String format;
    private String imgLink;
    private boolean avaliable;
    private List<RentedMovie> rentedMovies;
    private final String defaultImageUrl =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/450px-No_image_available.svg.png";
    public Movie(){

    }

    public Movie(String name, String description, String releaseDate, String category, String format,String imgLink, boolean avaliable) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.category = category;
        if (imgLink != "") {
            this.imgLink = imgLink;
        } else
            this.imgLink = defaultImageUrl;
        this.format = format;
        this.avaliable = avaliable;


    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
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

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    @OneToMany(mappedBy = "movie")
    public List<RentedMovie> getRentedMovies() {
        return rentedMovies;
    }

    public void setRentedMovies(List<RentedMovie> rentedMovies) {
        this.rentedMovies = rentedMovies;
    }
}
