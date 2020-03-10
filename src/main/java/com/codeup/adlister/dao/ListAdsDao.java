//package com.codeup.adlister.dao;
//
//import com.codeup.adlister.models.Ad;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ListAdsDao implements Ads {
//    private List<Ad> ads;
//
//    public List<Ad> all() {
//        if (ads == null) {
//            ads = generateAds();
//        }
//        return ads;
//    }
//
//    public int insert(Ad ad) {
//        if (ads == null) {
//            ads = generateAds();
//        }
//        // we'll assign an "id" here based on the size of the ads list
//        // really the dao would handle this
//        ad.setId((int) ads.size());
//        ads.add(ad);
//        return ad.getId();
//    }
//
//    private List<Ad> generateAds() {
//        List<Ad> ads = new ArrayList<>();
//        ads.add(new Ad(
//            1,
//            1,
//            "playstation for sale",
//            "This is a slightly used playstation",
//            89.00,
//            "03/20/20",
//            "games, console, playstation"
//        ));
//        ads.add(new Ad(
//            2,
//            1,
//            "Super Nintendo",
//            "Get your game on with this old-school classic!",
//            59.00,
//            "01/15/20",
//            "1, old, supernintendo"
//        ));
//        ads.add(new Ad(
//            3,
//            2,
//            "Junior Java Developer Position",
//            "Minimum 7 years of experience required. You will be working in the scripting language for Java, " +
//                    "JavaScript",
//            85000,
//            "02/03/20",
//            "Job, Developer, Java, Position"
//        ));
//        ads.add(new Ad(
//            4,
//            2,
//            "JavaScript Developer needed",
//            "Must have strong Java skills",
//            75000,
//            "02/15/20",
//            "Job, Developer, JavaScript, Position"
//        ));
//        return ads;
//    }
//}
