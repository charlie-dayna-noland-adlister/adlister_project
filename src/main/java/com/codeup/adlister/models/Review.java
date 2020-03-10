package com.codeup.adlister.models;

public class Review {
    private int id;
    private int userId;
    private String reviewText;
    private int rating;
    //BLOB PLACEHOLDER private Blob image;
    private String imageText;
    private int adId;

    public Review(){}

    public Review(int id, int userId, String reviewText, int rating, String imageText, int adId){
        this.id = id;
        this.userId = userId;
        this.reviewText = reviewText;
        this.rating = rating;
        this.imageText = imageText;
        this.adId = adId;
    }

    public Review(int userId, String reviewText, int rating, String imageText, int adId){
        this.userId = userId;
        this.reviewText = reviewText;
        this.rating = rating;
        this.imageText = imageText;
        this.adId = adId;
    }

    public Review(int userId, String reviewText, int rating, int adId){
        this.userId = userId;
        this.reviewText = reviewText;
        this.rating = rating;
        this.adId = adId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }
}
