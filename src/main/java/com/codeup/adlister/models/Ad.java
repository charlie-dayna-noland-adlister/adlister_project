package com.codeup.adlister.models;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Ad {
    //VARIABLES
    private int id;
    private long userId;
    private String title;
    private String description;
    private double price;
    private String datePosted;
//    private Blob image_blob;
//    private text image;
    private int reviewAvr;
    private List<Integer> categoryId;
    private int quantityReported;
    private List<Integer> usersReported;


    // All inclusive constructor
    public Ad(int id, long userId, String title, String description, double price, String datePosted, int reviewAvr,
              List<Integer> categoryId, int quantityReported, List<Integer> usersReported) {
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
    public Ad(long userId, String title, String description, double price, String datePosted, int reviewAvr,
              List<Integer> categoryId, int quantityReported, List<Integer> usersReported) {
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
    public Ad(long userId, String title, String description, double price, String datePosted,
              List<Integer> categoryId, int quantityReported, List<Integer> usersReported) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.categoryId = categoryId;
        this.quantityReported = quantityReported;
        this.usersReported = usersReported;
    }

    // WITH AD ID without quantity and users reported
    public Ad(int id, long userId, String title, String description, double price, String datePosted,
              List<Integer> categoryId) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.categoryId = categoryId;
    }

    // WITHOUT AD ID, quantity and users reported
    public Ad(long userId, String title, String description, double price, String datePosted,
              List<Integer> categoryId) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.categoryId = categoryId;
    }


    public Ad(int id, String title, String description, Double price, List<Integer> categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.reviewAvr = 0;
        this.quantityReported = 0;
        this.usersReported = new ArrayList<>();

    }

    //ID VARIABLE
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
  //USER ID VARIABLE
    public long getUserId() {
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
    public List<Integer> getCategoryId() { return categoryId; }
    public void setCategoryId(List<Integer> categoryId) { this.categoryId = categoryId; }
  //QUANTITY REPORTED VARIABLE
    public int getQuantityReported() { return quantityReported; }
    public void setQuantityReported(int quantityReported) { this.quantityReported = quantityReported; }
  //USERS REPORTED VARIABLE
    public List<Integer> getUsersReported() { return usersReported; }
    public void setUsersReported(List<Integer> usersReported) { this.usersReported = usersReported; }
}
