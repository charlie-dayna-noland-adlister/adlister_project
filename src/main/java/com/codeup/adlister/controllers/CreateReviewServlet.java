package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Review;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateReviewServlet", urlPatterns = "/ads/review")
public class CreateReviewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/reviews/createReview.jsp")
                .forward(request, response);
        return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
//        Review review = (Review) request.getSession().getAttribute("review"); //reviw
        Ad ad = (Ad) request.getSession().getAttribute("ad"); //ad
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            response.sendRedirect("/login");
            return;
        }
        Review review = new Review(
                user.getId(), // for now we'll hardcode the user id
                request.getParameter("review_text"), //do these have to be written out the same as the mysql? review_text
                Integer.parseInt(request.getParameter("rating")),
                request.getParameter("image_text"), //image_text
                ad.getId() //should this be hardcoded too?
        );
        DaoFactory.getReviewsDao().insert(review);
        response.sendRedirect("/ads");
        return;
    }
}
