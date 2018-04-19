package com.example.demo.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CheckCustomerForm {

    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]{6}-[0-9]{4}")
    private String socialNumber;

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }
}
