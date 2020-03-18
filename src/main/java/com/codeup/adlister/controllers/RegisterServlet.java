package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        //CONSIDER HASHING HERE?
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        String zipcode = request.getParameter("zipcode");
        // validate input
        String pString = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)[a-zA-Z\\d]{6,}$";
        Pattern pattern = Pattern.compile(pString);
        Matcher matcher = pattern.matcher(password);
        if (username.matches("\\W+") || !matcher.matches() || !password.equals(password) || !email.matches(".+@.+\\.[a-z]{3,4}") || !zipcode.matches("[0-9]{5}")) {
            //CHANGE TO ERROR HANDLING
            response.sendRedirect("/register");
            return;
        }
        // create and save a new user
        User user = new User(
                username,
                email,
                password,
                request.getParameter("fileupload"), //change this name(id),
                Integer.parseInt(zipcode)
        );
        long userId = DaoFactory.getUsersDao().insert(user);

        user.setId(userId);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("/profile");
        return;
    }
}
