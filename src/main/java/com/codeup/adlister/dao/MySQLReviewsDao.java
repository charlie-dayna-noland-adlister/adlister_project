package com.codeup.adlister.dao;

import com.codeup.adlister.models.Review;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySQLReviewsDao implements Reviews {
    private Connection connection = null;

    public MySQLReviewsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getDBUsername(),
                    config.getDBPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Review> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM reviews;");
            ResultSet rs = stmt.executeQuery();
            return createReviewsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all reviews.", e);
        }
    }

    @Override
    public HashMap<Long, ArrayList<Review>> masterReviewList() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM reviews;");
            ResultSet rs = stmt.executeQuery();
            HashMap<Long, ArrayList<Review>> mapOfReviewList = new HashMap<>();
            while(rs.next()) {
                long adId = rs.getLong("ad_id");
                if(mapOfReviewList.get(adId) == null) {
                    ArrayList<Review> pushList = new ArrayList<>();
                    pushList.add(extractReview(rs));
                    mapOfReviewList.put(adId, pushList);
                } else {
                    ArrayList<Review> getList = mapOfReviewList.get(adId);
                    getList.add(extractReview(rs));
                    mapOfReviewList.put(adId, getList);
                }
            }
            return mapOfReviewList;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all list reviews.", e);
        }
    }

    @Override
    public Long insert(Review review) {
        try {
            String insertQuery = "INSERT INTO reviews(user_id, review_text, rating, image_text, ad_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, review.getUserId());
            stmt.setString(2, review.getReviewText());
            stmt.setInt(3, review.getRating());
            stmt.setString(4, review.getImageText()); //would this be 4 or 5 because of blob
            stmt.setLong(5, review.getAdId()); //5 or 6 because of blob
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1); //would this change?
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new review.", e);
        }
    }

    private Review extractReview(ResultSet rs) throws SQLException {
        return new Review(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getString("review_text"),
                rs.getInt("rating"),
                rs.getString("image_text"),
                rs.getInt("ad_id")
        );
    }

    private List<Review> createReviewsFromResults(ResultSet rs) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        while (rs.next()) {
            reviews.add(extractReview(rs));
        }
        return reviews;
    }

    @Override
    public Review findById(long id) {
        String query = "SELECT * FROM reviews WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractReview(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a review by id. ID was " + id, e);
        }
    }

    @Override
    public boolean deleteReview(Review review) {
        try {
            String query = "DELETE FROM ads_reviews WHERE reviews_id=?;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, review.getId());
            stmt.execute();
            query = "DELETE FROM reviews WHERE id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, review.getId());
            return stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting an ad.", e);
        }    }

    @Override
    public boolean updateReview(Review review) {
        return false;
    }
}
