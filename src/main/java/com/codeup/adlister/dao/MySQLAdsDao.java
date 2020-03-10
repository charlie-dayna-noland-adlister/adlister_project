package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public int insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, price, date_posted) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setDouble(4, ad.getPrice());
            stmt.setString(5, ad.getDatePosted());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        int adId = rs.getInt("id");

        ArrayList<Integer> categoryArr = new ArrayList<>();
        try {
            String categoryId = "SELECT categories_id FROM ads_categories WHERE ads_id = " + adId;
            PreparedStatement stmt = connection.prepareStatement(categoryId, Statement.RETURN_GENERATED_KEYS);

            stmt.executeUpdate();
            ResultSet resSet = stmt.getGeneratedKeys();
            resSet.next();
            while (resSet.next()){
                categoryArr.add(resSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }

        ArrayList<Integer> reportsArr = new ArrayList<>();
        try {
            String reportsId = "SELECT reported_user_id FROM ads_reported_users WHERE ads_id = " + adId;
            PreparedStatement stmt = connection.prepareStatement(reportsId, Statement.RETURN_GENERATED_KEYS);

            stmt.executeUpdate();
            ResultSet resSet = stmt.getGeneratedKeys();
            resSet.next();
            while (resSet.next()){
                reportsArr.add(resSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }

        return new Ad(
            rs.getInt("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getDouble("price"),
            rs.getString("datePosted"),
            rs.getInt("reviewAvr"),
            categoryArr,
            rs.getInt("quantityReported"),
            reportsArr
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }







    private void addCategories (List<Integer> categories) throws SQLException {
        String addCat = "INSERT INTO ads_categories (ads_id, categories_id) VALUES (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(addCat, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, );
        stmt.setInt(2, getTitle());

        stmt.executeUpdate();
        ResultSet resSet = stmt.getGeneratedKeys();
        resSet.next();
    }
}
