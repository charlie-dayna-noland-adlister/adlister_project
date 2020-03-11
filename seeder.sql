

use adlister_database;

INSERT INTO ads (user_id, title, description, price, date_posted, image_text, review_avr, quantity_reported)
VALUES (1, 'Yippie', 'yippie add yippie', 23.99, '2020-01-30', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FBob_Saget&psig=AOvVaw1SWTbFNjcu3irZSFHI7CDF&ust=1583959130621000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNDU79zhkOgCFQAAAAAdAAAAABAD', 3,  0),
       (2, 'Yippie Yeehaw', 'yippie add yippie', 23.99, '2020-01-30', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FBob_Saget&psig=AOvVaw1SWTbFNjcu3irZSFHI7CDF&ust=1583959130621000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNDU79zhkOgCFQAAAAAdAAAAABAD', 5,  2),
       (3, 'Yippie', 'yippie add yippie uuppie', 23.99, '2020-01-30', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FBob_Saget&psig=AOvVaw1SWTbFNjcu3irZSFHI7CDF&ust=1583959130621000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNDU79zhkOgCFQAAAAAdAAAAABAD', 3,  0);


INSERT INTO reviews (user_id, review_text, rating, image_text, ad_id)
VALUES
    (1, 'It was good and cool and stuff.', 4, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FBob_Saget&psig=AOvVaw1SWTbFNjcu3irZSFHI7CDF&ust=1583959130621000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNDU79zhkOgCFQAAAAAdAAAAABAD', 1),
    (1, 'It was ok and sort of cool and stuff.', 3, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FBob_Saget&psig=AOvVaw1SWTbFNjcu3irZSFHI7CDF&ust=1583959130621000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNDU79zhkOgCFQAAAAAdAAAAABAD', 2),
    (2, 'Yesss that was cool.', 5, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FBob_Saget&psig=AOvVaw1SWTbFNjcu3irZSFHI7CDF&ust=1583959130621000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNDU79zhkOgCFQAAAAAdAAAAABAD', 1);

INSERT INTO categories (type)
VALUES
    ('cats'),
    ('money'),
    ('games');

INSERT INTO ads_categories (ads_id, categories_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (3, 1),
    (3, 3);

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
    (3, 1),
    (1, 2),
    (3, 2);