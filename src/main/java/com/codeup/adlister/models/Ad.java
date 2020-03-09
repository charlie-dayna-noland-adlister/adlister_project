package com.codeup.adlister.models;

import java.sql.Blob;

public class Ad {
    //VARIABLES
    private int id;
    private int userId;
    private String title;
    private String description;
    private double price;
    private String datePosted;
//    private Blob image_blob;
//    private text image;
    private int reviewAvr;
    private String categoryId;
    private int quantityReported;
    private String usersReported;


    // All inclusive constructor
    public Ad(int id, int userId, String title, String description, double price, String datePosted, int reviewAvr,
              String categoryId, int quantityReported, String usersReported) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.reviewAvr = reviewAvr;
        this.categoryId = categoryId;
        this.quantityReported = quantityReported;
        this.usersReported = usersReported;
    }

    // No AD ID constructor
    public Ad(int userId, String title, String description, double price, String datePosted, int reviewAvr,
              String categoryId, int quantityReported, String usersReported) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.reviewAvr = reviewAvr;
        this.categoryId = categoryId;
        this.quantityReported = quantityReported;
        this.usersReported = usersReported;
    }

    // No ID/NULL capable variables constructor
    public Ad(int userId, String title, String description, double price, String datePosted,
              String categoryId, int quantityReported, String usersReported) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.categoryId = categoryId;
        this.quantityReported = quantityReported;
        this.usersReported = usersReported;
    }

  //ID VARIABLE
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
  //USER ID VARIABLE
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
  //TITLE VARIABLE
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
  //DESCRIPTION VARIABLE
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
  //PRICE VARIABLE
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
  //DATE POSTED VARIABLE
    public String getDatePosted() { return datePosted; }
    public void setDatePosted(String datePosted) { this.datePosted = datePosted; }
  //REVIEW AVR VARIABLE
    public int getReviewAvr() { return reviewAvr; }
    public void setReviewAvr(int reviewAvr) { this.reviewAvr = reviewAvr; }
  //CATEGORY ID VARIABLE
    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
  //QUANTITY REPORTED VARIABLE
    public int getQuantityReported() { return quantityReported; }
    public void setQuantityReported(int quantityReported) { this.quantityReported = quantityReported; }
  //USERS REPORTED VARIABLE
    public String getUsersReported() { return usersReported; }
    public void setUsersReported(String usersReported) { this.usersReported = usersReported; }
}
