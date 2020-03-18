package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/ads")
public class AdsIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        return;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            response.sendRedirect("/login");
            return;
        }
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(now);
        List<Long> catIdList = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            String paramString = String.format("cat-id-%d", i);
            if(request.getParameter(paramString) != null) {
                catIdList.add(Long.parseLong(request.getParameter(paramString)));
            }
        }
        String imageText = "";
        if(request.getParameter("fileupload") == null) {
            imageText = "https://edit.co.uk/uploads/2016/12/Image-1-Alternatives-to-stock-photography-Thinkstock.jpg";
        } else {
            imageText = request.getParameter("fileupload");
        }
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                Double.parseDouble(request.getParameter("price")),
                date,
                imageText,
                catIdList
        );
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long adId = Long.parseLong(req.getParameter("id"));
        User user = (User)req.getSession().getAttribute("user");
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            resp.sendRedirect("/login");
            return;
        }
        Ad ad = DaoFactory.getAdsDao().findById(adId);
        if (ad == null || user == null || user.getId() != ad.getUserId()) {
            resp.sendRedirect("/ads");
            return;
        }
        boolean isDeleted = DaoFactory.getAdsDao().deleteAd(ad);
        resp.sendRedirect("/ads");
        return;
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        long adId = Long.parseLong(request.getParameter("id"));
        if (user == null || !(user instanceof User) || DaoFactory.getUsersDao().findByUsername(user.getUsername()) == null) {
            response.sendRedirect("/login");
            return;
        }
        Ad ad = DaoFactory.getAdsDao().findById(adId);
        if (ad == null || user.getId() != ad.getUserId()) {
            response.sendRedirect("/ads");
            return;
        }
        List<Long> catIdList = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            String paramString = String.format("cat-id-%d", i);
            if(request.getParameter(paramString) != null) {
                catIdList.add(Long.parseLong(request.getParameter(paramString)));
            }
        }
//        String[] catIds = request.getParameter("categoryId").split(" ");
//        List<Long> catIdList = new ArrayList<>();
//        for (String catId : catIds){
//            catIdList.add(Long.parseLong(catId));
//        }

        ad.setTitle(request.getParameter("title"));
        ad.setDescription(request.getParameter("description"));
        ad.setPrice(Double.parseDouble(request.getParameter("price")));
        ad.setCategoryIdList(catIdList);

        DaoFactory.getAdsDao().updateAd(ad);
        response.sendRedirect("/ads");
        return;
    }
}
