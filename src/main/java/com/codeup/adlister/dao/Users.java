package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User extractUser(ResultSet rs) throws SQLException;
}
