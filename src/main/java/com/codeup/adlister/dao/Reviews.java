package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Reviews {
    // get a list of all the ads
    List<Review> all();
    // insert a new ad and return the new ad's id
    Long insert(Review review);

    Review findById(long id);
    boolean deleteReview(Review review);
    boolean updateReview(Review review);
    public HashMap<Long, ArrayList<Review>> masterReviewList();
}
