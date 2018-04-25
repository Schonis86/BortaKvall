package com.example.demo.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CheckCustomerForm {

    @Size(min = 2)
    @Pattern(regexp = "^[0-9]{6}-[0-9]{4}", message = "Enter as xxxxxx-xxxx")
    private String socialNumber;

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }
}
