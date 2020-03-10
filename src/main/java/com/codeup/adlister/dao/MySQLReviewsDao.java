package com.codeup.adlister.dao;

import com.codeup.adlister.models.Review;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            stmt = connection.prepareStatement("SELECT * FROM reviews");
            ResultSet rs = stmt.executeQuery();
            return createReviewsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all reviews.", e);
        }
    }

    @Override
    public Long insert(Review review) {
        try {
            String insertQuery = "INSERT INTO reviews(user_id, review_text, rating, image_text, ad_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInteger(1, review.getUserId());
            stmt.setString(2, review.getReviewText());
            stmt.setInteger(3, review.getRating());
            stmt.setString(4, review.getImageText()); //would this be 4 or 5 because of blob
            stmt.setInteger(5, review.getAdId()); //5 or 6 because of blob
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

    private List<Review> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        while (rs.next()) {
            reviews.add(extractReview(rs));
        }
        return reviews;
    }
}
