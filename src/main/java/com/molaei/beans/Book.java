package com.molaei.beans;

public class Book {
    private String title;
    private String price;
    private String year;

    public Book(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Book ----> title: %s , Price : %S, Year : %S", this.title, this.price, this.year);
    }
}
