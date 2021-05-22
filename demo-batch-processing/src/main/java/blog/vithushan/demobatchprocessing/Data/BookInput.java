/*
 * File: BookInput.java
 * Project: Data
 * File Created: Thursday, 20th May 2021 2:02:01 am
 * Author: Vithushan Sylvester (msvithushan@gmail.com)
 * -----
 * Last Modified: Saturday, 22nd May 2021 2:57:48 pm
 * Modified By: Vithushan Sylvester (msvithushan@gmail.com>)
 * -----
 * Copyright <<projectCreationYear>> - 2021 Vithushan Sylvester, CtrlX
 */

package blog.vithushan.demobatchprocessing.Data;

public class BookInput {
    private String bookID;
    private String title;
    private String authors;
    private String average_rating;
    private String isbn;
    private String isbn13;
    private String language_code;
    private String num_pages;
    private String ratings_count;
    private String text_reviews_count;
    private String publication_date;
    private String publisher;
    
    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthors() {
        return authors;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    public String getAverage_rating() {
        return average_rating;
    }
    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getIsbn13() {
        return isbn13;
    }
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }
    public String getLanguage_code() {
        return language_code;
    }
    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }
    public String getNum_pages() {
        return num_pages;
    }
    public void setNum_pages(String num_pages) {
        this.num_pages = num_pages;
    }
    public String getRatings_count() {
        return ratings_count;
    }
    public void setRatings_count(String ratings_count) {
        this.ratings_count = ratings_count;
    }
    public String getText_reviews_count() {
        return text_reviews_count;
    }
    public void setText_reviews_count(String text_reviews_count) {
        this.text_reviews_count = text_reviews_count;
    }
    public String getPublication_date() {
        return publication_date;
    }
    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    
}
