package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Review;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/reviews")
public class ReviewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/partials/reviews.jsp")
                .forward(request, response);
            return;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
//        Review review = (Review) request.getSession().getAttribute("review"); //review
        Ad ad = (Ad) request.getSession().getAttribute("ad"); //ad
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            response.sendRedirect("/login");
            return;
        }
        Review review = new Review(
                user.getId(), // for now we'll hardcode the user id
                request.getParameter("reviewText"), //do these have to be written out the same as the mysql? review_text
                Integer.parseInt(request.getParameter("rating")),
                request.getParameter("imageText"), //image_text
//               ad.getId() //should this be hardcoded too?
                1 //hardcoded
        );
        DaoFactory.getReviewsDao().insert(review);
        response.sendRedirect("/ads");
        return;
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long reviewId = Long.parseLong(req.getParameter("id"));
        User user = (User)req.getSession().getAttribute("user");
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            resp.sendRedirect("/login");
            return;
        }
        Review review = DaoFactory.getReviewsDao().findById(reviewId);
        if (review == null || user == null || user.getId() != review.getUserId()) {
            resp.sendRedirect("/ads");
            return;
        }
        boolean isDeleted = DaoFactory.getReviewsDao().deleteReview(review);
        resp.sendRedirect("/profile");
        return;
    }
}
