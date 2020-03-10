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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
//        String date = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(now);

        String[] catIds = request.getParameter("categoryId").split(" ");
        List<Integer> catList = new ArrayList<>();
        for (String catId : catIds){
           catList.add(Integer.parseInt(catId));
        }

        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description"),
            Double.parseDouble(request.getParameter("price")),
            mysqlDateString,
            catList
        );
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
        return;
    }
}
