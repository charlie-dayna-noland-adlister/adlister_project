use adlister_database;

INSERT INTO ads (user_id, title, description, price, date_posted, image_text, review_avr, quantity_reported)
VALUES (1, 'Lysol Dual Action Disinfecting Wipes', 'If youre unable to find disinfecting wipes at your local grocery store, this is the product for you! Container is unopened. Price includes cost of shipping!', 25.00, '2020-01-30', 'https://mercari-images.global.ssl.fastly.net/photos/m28521643056_1.jpg?1583980334', 3,  0),
       (2, 'Sony PS4 Controller', 'Brand new, package unopened. Sunset orange PS4 controller.', 37.99, '2020-02-20', 'https://mercari-images.global.ssl.fastly.net/photos/m44004673131_1.jpg?1583981654', 5,  2),
       (3, 'Womens Leather Jacket', 'Womens lack faux leather jacket. Lightly used. Size medium.', 33.99, '2020-01-30', 'https://mercari-images.global.ssl.fastly.net/photos/m84501302351_1.jpg?1583981505', 3,  0),
       (4, 'Man Cave Clock', 'Bud light vintage clock. Great for man cave.', 19.99, '2019-12-30', 'https://mercari-images.global.ssl.fastly.net/photos/m17673035555_1.jpg?1583982588', 2,  0),
       (1, 'Rae Dunn Canister Bundle', 'Kitchen canisters. Unused with tags.', 49.99, '2019-12-30', 'https://mercari-images.global.ssl.fastly.net/photos/m44465894552_1.jpg?1583982424', 4,  0),
       (3, 'Inverted Umbrella', 'Purple and black inverted umbrella. Lightly used.', 18.99, '2019-12-30', 'https://mercari-images.global.ssl.fastly.net/photos/m45950231397_1.jpg?1583982833', 4,  0),
       (2, 'Happy Notes Have Courage and Be Kind Notebook', 'Brand new, never used Have Courage and Be Kind Happy Notes Notebook from MAMBI. Dimensions: 7" x 9.25"', 11.50, '2019-11-15', 'https://mercari-images.global.ssl.fastly.net/photos/m33249405220_1.jpg?1583983604', 4,  0),
       (4, 'Near Mint Dragonite GX Secret Rare', 'Near Mint Dragonite GX Secret Rare Pokemon Card from the Pokemon Unified Minds Set. Card is in Near Mint Condition', 37.50, '2020-03-05', 'https://mercari-images.global.ssl.fastly.net/photos/m46615462135_1.jpg?1583975612', 4,  0),
       (3, 'Makeup Brushes Set 20pcs', '20 piece set as shown. Unused, still in packaging', 15.50, '2020-03-11', 'https://mercari-images.global.ssl.fastly.net/photos/m50131414570_1.jpg?1583983250', 3,  0);


INSERT INTO reviews (user_id, review_text, rating, image_text, ad_id)
VALUES
    (1, 'SOOOOOOOOOO expensive! But I dont have coronavirus!', 4, 'https://mercari-images.global.ssl.fastly.net/photos/m28521643056_2.jpg?1583980334', 1),
    (1, 'Satisfied with my purchase. Delivered as advertised', 3, 'https://mercari-images.global.ssl.fastly.net/photos/m44004673131_1.jpg?1583981654', 2),
    (2, 'definitely worth not getting coronavirus! 10/10 would recommend!', 5, 'https://mercari-images.global.ssl.fastly.net/photos/m28521643056_2.jpg?1583980334', 1),
    (2, 'Fits perfectly! I love it!', 5, 'https://mercari-images.global.ssl.fastly.net/photos/m84501302351_5.jpg?1583981505', 3),
    (3, 'Theyre beautiful and came packaged so well!', 5, 'https://mercari-images.global.ssl.fastly.net/photos/m44465894552_2.jpg?1583982424', 5),
    (1, 'Closest thing to damage was this tiny tear. I love my new planner!', 4, 'https://mercari-images.global.ssl.fastly.net/photos/m33249405220_3.jpg?1583983604', 7),
    (2, 'They took longer to ship than expected.', 3, 'https://mercari-images.global.ssl.fastly.net/photos/m50131414570_2.jpg?1583983250', 9);

INSERT INTO categories (type)
VALUES
    ('clothing'),
    ('accessories'),
    ('toys'),
    ('appliances'),
    ('books'),
    ('garden & outdoor'),
    ('home decor'),
    ('home & kitchen'),
    ('sports & outdoors'),
    ('electronics'),
    ('tools'),
    ('crafts'),
    ('handmade'),
    ('men'),
    ('women'),
    ('kids'),
    ('baby'),
    ('pet'),
    ('other'),
    ('games');

INSERT INTO ads_categories (ads_id, categories_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (3, 1),
    (3, 3);

INSERT INTO ads_reviews (ads_id, reviews_id)
VALUES
    (1, 1),
    (2, 2),
    (1, 3),
    (3, 4),
    (5, 5),
    (7, 6),
    (9, 7);

INSERT INTO users_followed (user_id, followed_id)
VALUES
    (1, 2),
    (1, 3),
    (2, 1);


INSERT INTO ads_reported_users (ads_id, reported_user_id)
VALUES
    (2, 1),
    (2, 3);

INSERT INTO users_ads (ads_id, user_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 1),
    (6, 3),
    (7, 2),
    (8, 4),
    (9, 3);