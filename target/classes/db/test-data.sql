DELETE FROM customer;
INSERT INTO customer(id, name, pass)
VALUES (1, 'user', '123abc');

DELETE FROM addiction;
INSERT INTO addiction(id, name, suggestion, picUrl, userId)
VALUES (1, 'Onychophagy', 'hsdgakv', 'nailbite1.jpeg', 1),
       (2, 'Horoscopemania', 'asjfhvaahj', 'horoscope1.jpeg', 1),
       (3, 'LOL addiction', 'akfbs', 'lol1.jpeg', 1),
       (4, 'Midget porn', 'advkjdbvak', 'midget1.jpeg', 1);
