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
    public Ad findById(long id) {
        String query = "SELECT * FROM ads WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an ad by id. ID was " + id, e);
        }
    }
    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads;");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, price, date_posted, image_text, review_avr, quantity_reported) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setDouble(4, ad.getPrice());
            stmt.setString(5, ad.getDatePosted());
            stmt.setString(6, ad.getImageText());
            stmt.setInt(7, ad.getReviewAvr());
            stmt.setInt(8, ad.getQuantityReported());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            ad.setId(rs.getLong(1));
            addCategories(ad);
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        long adId = rs.getLong("id");

        List<Long> categoryList = new ArrayList<>();
        try {
            String categoryId = "SELECT categories_id FROM ads_categories WHERE ads_id = " + adId;
            PreparedStatement stmt = connection.prepareStatement(categoryId);
            ResultSet resSet = stmt.executeQuery();
            resSet.next();
            while (resSet.next()){
                categoryList.add(resSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }

        List<Long> reportsList = new ArrayList<>();
        try {
            String reportsId = "SELECT reported_user_id FROM ads_reported_users WHERE ads_id = " + adId;
            PreparedStatement stmt = connection.prepareStatement(reportsId);
            stmt.executeQuery();
            ResultSet resSet = stmt.executeQuery();
            resSet.next();
            while (resSet.next()){
                reportsList.add(resSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }

        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getDouble("price"),
            rs.getString("date_posted"),
            rs.getString("image_text"),
            rs.getInt("review_avr"),
            categoryList,
            rs.getInt("quantity_reported"),
            reportsList
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
    private void addCategories (Ad ad) throws SQLException {
        for(Long catId : ad.getCategoryId()) {
            String insertStatement = "INSERT INTO ads_categories(ads_id, categories_id) VALUES (?, ?);";
            PreparedStatement catStmt= connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
            catStmt.setLong(1, ad.getId());
            catStmt.setLong(2, catId);
            catStmt.executeUpdate();
        }
    }
    @Override
    public boolean deleteAd(Ad ad) {
        try {
            String query = "DELETE FROM users_ads WHERE ads_id=?;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad.getId());
            stmt.execute();
            query = "DELETE FROM ads_reported_users WHERE ads_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad.getId());
            stmt.execute();
            query = "DELETE FROM ads_categories WHERE ads_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad.getId());
            stmt.execute();
            query = "DELETE FROM ads WHERE id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad.getId());
            return stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting an ad.", e);
        }
    }
    @Override
    public boolean updateAd(Ad ad) {
        try {
            String query = "UPDATE ads SET title = ?, description = ?, price = ?, image_text = ?, WHERE id = ?;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setDouble(3, ad.getPrice());
            stmt.setString(4, ad.getImageText());
            stmt.execute();
            //delete then update
            query = "DELETE FROM ads_categories WHERE ads_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad.getId());
            stmt.execute();
            addCategories(ad);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting an ad.", e);
        }
    }
}
