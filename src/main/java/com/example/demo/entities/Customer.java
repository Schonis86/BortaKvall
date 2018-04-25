package com.example.demo.entities;

import com.example.demo.Controllers.RentalController;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.MovieRepository;
import com.example.demo.repositories.RentedMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {


    private String socialNumber;

    private String fName;

    private String lName;

    private String address;

    private String zipCode;

    private String city;

    private String country;

    private String phone;

    private String email;

    private List<RentedMovie> rentedMovies;

    public Customer(){

    }


    public Customer(String socialNumber, String fName, String lName, String address, String zipCode, String city, String country, String phone, String email) {
        this.socialNumber = socialNumber;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }


    public boolean hasRentedMovies(RentedMovieRepository rentRepo) {

        List<RentedMovie> addMovies = rentRepo.findByRentedMovieKeySocialNumber(getSocialNumber());

        return addMovies.stream()
                .anyMatch(m -> m.getToDate() == null);

    }


    @Id
    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "customer")
    public List<RentedMovie> getRentedMovies() {
        return rentedMovies;
    }

    public void setRentedMovies(List<RentedMovie> rentedMovies) {
        this.rentedMovies = rentedMovies;
    }
}
