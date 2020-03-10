package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
        return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            response.sendRedirect("/login");
            return;
        }
        Ad ad = new Ad(
            user.getId(), // for now we'll hardcode the user id
            request.getParameter("title"),
            request.getParameter("description"),
            request.getParameter("price"),
            request.getParameter("categoryId")
        );
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
        return;
    }
}
