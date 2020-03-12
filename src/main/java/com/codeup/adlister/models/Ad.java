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
    private List<String> categoryList;
    private List<Long> reviewsIdList;
    private List<Review> reviewsList;
    private int quantityReported;
    private List<Long> usersReportedIdList;
    private List<User> usersReportedList;

    public Ad() {}
    //Construct Ads from Database(used in program)

    public Ad(long id, long userId, String title, String description, double price, String datePosted, String imageText, int reviewAvr, List<Long> categoryIdList, List<String> categoryList, List<Long> reviewsIdList, List<Review> reviewsList, int quantityReported, List<Long> usersReportedIdList, List<User> usersReportedList) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.imageText = imageText;
        this.reviewAvr = reviewAvr;
        this.categoryIdList = categoryIdList;
        this.categoryList = categoryList;
        this.reviewsIdList = reviewsIdList;
        this.reviewsList = reviewsList;
        this.quantityReported = quantityReported;
        this.usersReportedIdList = usersReportedIdList;
        this.usersReportedList = usersReportedList;
    }

    public Ad(long userId, String title, String description, double price, String datePosted, String imageText, List<Long> categoryIdList) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.datePosted = datePosted;
        this.imageText = imageText;
        this.reviewAvr = 3;
        this.categoryIdList = categoryIdList;
        this.categoryList = new ArrayList<>();
        this.reviewsIdList = new ArrayList<>();
        this.reviewsList = new ArrayList<>();
        this.quantityReported = 0;
        this.usersReportedIdList = new ArrayList<>();
        this.usersReportedList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public int getReviewAvr() {
        return reviewAvr;
    }

    public void setReviewAvr(int reviewAvr) {
        this.reviewAvr = reviewAvr;
    }

    public List<Long> getCategoryIdList() {
        return categoryIdList;
    }

    public void setCategoryIdList(List<Long> categoryIdList) {
        this.categoryIdList = categoryIdList;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Long> getReviewsIdList() {
        return reviewsIdList;
    }

    public void setReviewsIdList(List<Long> reviewsIdList) {
        this.reviewsIdList = reviewsIdList;
    }

    public List<Review> getReviewsList() {
        return reviewsList;
    }

    public void setReviewsList(List<Review> reviewsList) {
        this.reviewsList = reviewsList;
    }

    public int getQuantityReported() {
        return quantityReported;
    }

    public void setQuantityReported(int quantityReported) {
        this.quantityReported = quantityReported;
    }

    public List<Long> getUsersReportedIdList() {
        return usersReportedIdList;
    }

    public void setUsersReportedIdList(List<Long> usersReportedIdList) {
        this.usersReportedIdList = usersReportedIdList;
    }

    public List<User> getUsersReportedList() {
        return usersReportedList;
    }

    public void setUsersReportedList(List<User> usersReportedList) {
        this.usersReportedList = usersReportedList;
    }
}
