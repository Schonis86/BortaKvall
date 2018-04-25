package com.example.demo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerForm {
    @Size(min = 11, max = 11, message = "must contain 11 numbers")
    @Pattern(regexp = "^[0-9]{6}-[0-9]{4}", message = "enter as xxxxxx-xxxx")
    private String socialNumber;
    @NotNull
    @Size(min = 2, message = "Required")
    private String fName;
    @NotNull
    @Size(min = 2, message = "Required")
    private String lName;
    @NotNull
    @Size(min = 2, message = "Required")
    private String address;
    @NotNull
    @Size(min = 2, message = "Required")
    @Pattern(regexp = "^[0-9]{3}\\s[0-9]{2}", message = "enter as xxx xx")
    private String zipCode;
    @NotNull
    @Size(min = 2, message = "Required")
    private String city;
    @NotNull
    @Size(min = 2, message = "Required")
    private String country;
    @NotNull
    @Size(min = 9, max = 11, message = "Required")
    @Pattern(regexp = "[0-9]{3,4}-[0-9]{6,7}", message = "enter as xxx-xxxxxxx")
    private String phone;
    @NotNull
    @Size(min = 2, message = "Required")
    private String email;


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
}
