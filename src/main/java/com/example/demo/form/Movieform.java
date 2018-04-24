package com.example.demo.form;

import javafx.beans.DefaultProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Movieform {



    private Long produktNumber;
    @NotNull
    @Size(min = 2)
    private String name;
    @Size(min = 2)
    private String description;
    @Size(min = 2)
    private String releaseDate;
    @Size(min = 2)
    private String category;
    @Size(min = 2)
    private String format;

    private String imgLink;
}
