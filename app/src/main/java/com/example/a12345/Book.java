package com.example.a12345;

public class Book {
    String title;
    String author;
    String ratings;
    String price;
    int image;

    public Book(String title, String author,
                String ratings, String price,
                int image) {
        this.title = title;
        this.author = author;
        this.ratings = ratings;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getRatings() {
        return ratings;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
