package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import com.mysql.cj.jdbc.Driver;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password, image_text, user_avr, users_followed, times_reported, num_ads_reported, num_reviews, wishlist, zipcode, is_admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            String hash = Password.hash(user.getPassword());
            stmt.setString(3, hash);
            stmt.setString(4, user.getProfileImageText());
            stmt.setInt(5, user.getAverageRating());
            String usersFollowedString = String.join(",", user.getUsersFollowedList());
            stmt.setString(6, usersFollowedString);
            stmt.setInt(7, user.getTimesReported());
            stmt.setInt(8, user.getNumAdsReported());
            stmt.setInt(9, user.getNumReviews());
            String wishListString = String.join(",", user.getWishList());
            stmt.setString(10, wishListString);
            stmt.setInt(11, user.getZipcode());
            int admin = user.isAdmin() ? 1 : 0;
            stmt.setInt(12, admin);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        List<String> followedList = Arrays.asList(rs.getString("users_followed").split(","));
        List<String> wishList = Arrays.asList(rs.getString("wishList").split(","));
        boolean isAdmin = 1 == rs.getInt("is_admin");
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("image_text"),
                rs.getInt("user_avr"),
                followedList,
                rs.getInt("times_reported"),
                rs.getInt("num_ads_reported"),
                rs.getInt("num_reviews"),
                wishList,
                rs.getInt("zipcode"),
                isAdmin
        );
    }

}
