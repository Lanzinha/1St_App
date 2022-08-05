DELETE
FROM customer;
INSERT INTO customer(id, name, pass)
VALUES (1, 'user', '123abc');

DELETE
FROM addiction;
INSERT INTO addiction(id, name, title, suggestion, picUrl, userId)
VALUES (1, 'Onychophagy', 'Don''t blame the stars for your bad behavior!',
        'Are you loosing your friends because you can''t stop talking about the planets and moons? No shit. ' ||
        'Make the Universe a favor and knock it off.', 'https://i.postimg.cc/1zw2ZKZW/nails.gif', 1),
       (2, 'Horoscopemania', 'Don''t eat your hands! "Eat" your friends!',
        'Did you know your hands are full of germs? 1 in 350,000 people die every year of nail biting. ' ||
        'Check yourself before you wreck yourself.',
        'https://i.postimg.cc/nh70scwr/finger.gif', 1),
       (3, 'LOL addiction', 'One million reasons you won''t rank up this season',
        'But I''m pretty sure the Community already told you that. Touch grass!!',
        'https://i.postimg.cc/Y2Rc98LZ/teemo.jpg', 1),
       (4, 'Midget porn', 'There''s absolutely nothing wrong with that!', 'Love is love in all shapes and sizes!',
        'https://i.postimg.cc/fbnq500Y/minime.jpg', 1),
       (5, 'Tauromania', 'Are you addicted to going to the Touros?', 'Remember, animal also feel sad.  Love them all!!',
        'https://i.postimg.cc/x1Sd2tw7/touros.jpg', 1),
       (6, 'Sloppy', 'Can''t you do the dishes!?', 'We got news for you:  You''re old enough for that.',
        'https://i.postimg.cc/fLHK43k2/dishes.jpg', 1),;
