package com.alinab.springcourse.models;

import javax.validation.constraints.*;

public class Book {

    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 1, max = 255, message = "Name should be between 1 and 255 characters")
    private String title;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
    private String author;

    @NotNull(message = "Year should be 4 digits")
    @Positive(message = "Year should be greater than 0")
    private Integer year;

    public Book() { }

    public Book(int id, String title, String author, Integer year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
