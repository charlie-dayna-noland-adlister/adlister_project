package com.codeup.adlister.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String profileImageText;
    private int averageRating;
    private List<String> usersFollowedList;
    private int timesReported;
    private int numAdsReported;
    private int numReviews;
    private List<String> wishList;
    private int zipcode;
    private boolean isAdmin;


    public User() {}
//FROM THE DATABASE
    public User(long id, String username, String email, String password, String profileImageText, int averageRating, List<String> usersFollowedList, int timesReported, int numAdsReported, int numReviews, List<String> wishList, int zipcode, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImageText = profileImageText;
        this.averageRating = averageRating;
        this.usersFollowedList = usersFollowedList;
        this.timesReported = timesReported;
        this.numAdsReported = numAdsReported;
        this.numReviews = numReviews;
        this.wishList = wishList;
        this.zipcode = zipcode;
        this.isAdmin = isAdmin;
    }
//FROM THE APP VIEW
    public User(String username, String email, String password, String profileImageText, int zipcode, boolean isAdmin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImageText = profileImageText;
        this.averageRating = 3;
        this.usersFollowedList = new ArrayList<>();
        this.timesReported = 0;
        this.numAdsReported = 0;
        this.numReviews = 0;
        this.wishList = new ArrayList<>();
        this.zipcode = zipcode;
        this.isAdmin = isAdmin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImageText() {
        return profileImageText;
    }

    public void setProfileImageText(String profileImageText) {
        this.profileImageText = profileImageText;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getUsersFollowedList() {
        return usersFollowedList;
    }

    public void setUsersFollowedList(List<String> usersFollowedList) {
        this.usersFollowedList = usersFollowedList;
    }

    public int getTimesReported() {
        return timesReported;
    }

    public void setTimesReported(int timesReported) {
        this.timesReported = timesReported;
    }

    public int getNumAdsReported() {
        return numAdsReported;
    }

    public void setNumAdsReported(int numAdsReported) {
        this.numAdsReported = numAdsReported;
    }

    public int getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }

    public List<String> getWishList() {
        return wishList;
    }

    public void setWishList(List<String> wishList) {
        this.wishList = wishList;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }
}
