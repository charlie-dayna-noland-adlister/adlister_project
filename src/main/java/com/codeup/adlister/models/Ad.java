package com.codeup.adlister.models;

import java.util.ArrayList;
import java.util.List;

public class Ad {
    //VARIABLES
    private long id;
    private long userId;
    private String title;
    private String description;
    private double price;
    private String datePosted;
    private String imageText;
    private int reviewAvr;
    private List<Long> categoryIdList;
    private int quantityReported;
    private List<Long> usersReportedList;

    public Ad() {}
    //Construct Ads from Database(used in program)
    public Ad(long id, long userId, String title, String description, double price, String datePosted, String imageText, int reviewAvr, List<Long> categoryIdList, int quantityReported, List<Long> usersReported) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.imageText = imageText;
        this.reviewAvr = reviewAvr;
        this.categoryIdList = categoryIdList;
        this.quantityReported = quantityReported;
        this.usersReportedList = usersReported;
    }
    //Construct Ads from user form submission(used to push to db when image is provided)
    public Ad(long userId, String title, String description, double price, String datePosted, String imageText, List<Long> categoryIdList) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.imageText = imageText;
        this.reviewAvr = 3;
        this.categoryIdList = categoryIdList;
        this.quantityReported = 0;
        this.usersReportedList = new ArrayList<>();
    }
//    //Construct Ads from user form submission(used to push to db when image is NOT provided)
//    public Ad(long userId, String title, String description, double price, List<Long> categoryId) {
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.datePosted = "";
//        this.imageText = "";
//        this.reviewAvr = 0;
//        this.categoryId = categoryId;
//        this.quantityReported = 0;
//        this.usersReported = new ArrayList<>();
//    }

    //    // All inclusive constructor
//    public Ad(int id, long userId, String title, String description, double price, String datePosted, int reviewAvr,
//              List<Integer> categoryId, int quantityReported, List<Integer> usersReported) {
//        this.id = id;
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.datePosted = datePosted;
//        this.reviewAvr = reviewAvr;
//        this.categoryId = categoryId;
//        this.quantityReported = quantityReported;
//        this.usersReported = usersReported;
//    }
//
//    // No AD ID constructor
//    public Ad(long userId, String title, String description, double price, String datePosted, int reviewAvr,
//              List<Integer> categoryId, int quantityReported, List<Integer> usersReported) {
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.datePosted = datePosted;
//        this.reviewAvr = reviewAvr;
//        this.categoryId = categoryId;
//        this.quantityReported = quantityReported;
//        this.usersReported = usersReported;
//    }
//
//    // No ID/NULL capable variables constructor
//    public Ad(long userId, String title, String description, double price, String datePosted,
//              List<Integer> categoryId, int quantityReported, List<Integer> usersReported) {
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.datePosted = datePosted;
//        this.categoryId = categoryId;
//        this.quantityReported = quantityReported;
//        this.usersReported = usersReported;
//    }
//
//    // WITH AD ID without quantity and users reported
//    public Ad(int id, long userId, String title, String description, double price, String datePosted,
//              List<Integer> categoryId) {
//        this.id = id;
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.datePosted = datePosted;
//        this.categoryId = categoryId;
//    }
//
//    // WITHOUT AD ID, quantity and users reported
//    public Ad(long userId, String title, String description, double price, String datePosted,
//              List<Integer> categoryId) {
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.datePosted = datePosted;
//        this.categoryId = categoryId;
//    }
//
//
//    public Ad(int id, String title, String description, Double price, List<Integer> categoryId) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.categoryId = categoryId;
//        this.reviewAvr = 0;
//        this.quantityReported = 0;
//        this.usersReported = new ArrayList<>();
//
//    }

    //ID VARIABLE
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
  //USER ID VARIABLE
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
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
    public List<Long> getCategoryId() { return categoryIdList; }
    public void setCategoryId(List<Long> categoryId) { this.categoryIdList = categoryId; }
  //QUANTITY REPORTED VARIABLE
    public int getQuantityReported() { return quantityReported; }
    public void setQuantityReported(int quantityReported) { this.quantityReported = quantityReported; }
  //USERS REPORTED VARIABLE
    public List<Long> getUsersReported() { return usersReportedList; }
    public void setUsersReported(List<Long> usersReported) { this.usersReportedList = usersReported; }

    public String getImageText() { return imageText; }

    public void setImageText(String imageText) { this.imageText = imageText; }
}
