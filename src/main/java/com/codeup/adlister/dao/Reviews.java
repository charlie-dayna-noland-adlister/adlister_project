package com.codeup.adlister.dao;

import com.codeup.adlister.models.Review;
import java.util.List;

public interface Reviews {
    // get a list of all the ads
    List<Review> all();
    // insert a new ad and return the new ad's id
    Long insert(Review review);
}
