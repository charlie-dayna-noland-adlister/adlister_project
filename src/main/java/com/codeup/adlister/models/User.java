package com.codeup.adlister.models;

import com.mysql.cj.jdbc.Blob;

import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private Blob profileImageBlob;
    private Image profileImageText;
    private int averageRating;
    private List<String> usersFollowedList;
    private int timesReported;
    private int numAdsReported;
    private int num_reviews;
    private List<String> wishList;
    private int zipcode;
    private boolean isAdmin;


    public User() {}
//FROM THE DATABASE
    public User(long id, String username, String email, String password, Blob profileImageBlob, Image profileImageText, int averageRating, List<String> usersFollowedList, int timesReported, int numAdsReported, int num_reviews, List<String> wishList, int zipcode, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImageBlob = profileImageBlob;
        this.profileImageText = profileImageText;
        this.averageRating = averageRating;
        this.usersFollowedList = usersFollowedList;
        this.timesReported = timesReported;
        this.numAdsReported = numAdsReported;
        this.num_reviews = num_reviews;
        this.wishList = wishList;
        this.zipcode = zipcode;
        this.isAdmin = isAdmin;
    }
//FROM THE APP VIEW
    public User(String username, String email, String password, Blob profileImageBlob, Image profileImageText, int zipcode, boolean isAdmin) {
        this.username = username;
        this.email = email;
        this.password = password;
//        this.profileImageBlob = new Blob();
        this.profileImageText = new Image() {
            @Override
            public int getWidth(ImageObserver observer) {
                return 0;
            }

            @Override
            public int getHeight(ImageObserver observer) {
                return 0;
            }

            @Override
            public ImageProducer getSource() {
                return null;
            }

            @Override
            public Graphics getGraphics() {
                return null;
            }

            @Override
            public Object getProperty(String name, ImageObserver observer) {
                return null;
            }
        };
        this.averageRating = 3;
        this.usersFollowedList = new ArrayList<>();
        this.timesReported = 0;
        this.numAdsReported = 0;
        this.num_reviews = 0;
        this.wishList = new ArrayList<>();
        this.zipcode = zipcode;
        this.isAdmin = isAdmin;
    }

    public User(String username, String email, String password) {
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

    public Blob getProfileImageBlob() {
        return profileImageBlob;
    }

    public void setProfileImageBlob(Blob profileImageBlob) {
        this.profileImageBlob = profileImageBlob;
    }

    public Image getProfileImageText() {
        return profileImageText;
    }

    public void setProfileImageText(Image profileImageText) {
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

    public int getNum_reviews() {
        return num_reviews;
    }

    public void setNum_reviews(int num_reviews) {
        this.num_reviews = num_reviews;
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
        isAdmin = admin;
    }
}
