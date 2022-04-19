INSERT INTO Trips (id, country, travelType, travelTime)
VALUES (1001, 'France', 'Sun holiday',  17),
       (1002, 'Estonia', 'City Trip', 4),
       (1003, 'USA', 'School Trip', 7);

INSERT INTO FutureTravels (id, country, areas, travelType, travelTime, expectedCosts)
VALUES (1001, 'USA', 'Los Angeles', 'road trip', 21, 5000),
       (1002, 'Lutjebroek', 'darmstad', 'sun trip', 4, 50),
       (1003, 'China', 'Beijing', 'asian trip', 15, 3700);

INSERT INTO travel_tips (id, name, country, city, description)
VALUES (1001, 'Awesome experience', 'Costa Rica', 'San Jose', 'Ik denk dat mijn tomatenplant een ziekte heeft opgelopen'),
       (1002, 'Frikandellen', 'Australia', 'Melbourne', 'Ik wil graag nog 3 verschillende soorten dahlias, korenbloemen en wat opvulling voor in de border'),
       (1003, 'Linkerknipperlichtkapje', 'België', 'Gent', 'GIVE-AWAY van heerlijke huisjes');

--INSERT INTO users (id, username, password, enabled, email, name, street, postalcode, city)
--VALUES (1001, 'TravelNerd', 'user', TRUE, 'info@travelnerd.com',  'Bas', 'Pietjepukweg 71', '1234AA', 'Groningen'),
--       (1002, 'Kasper', 'user', TRUE, 'info@kasper.nl', 'Kasper', 'Puinhoop 5', '8008SS', 'Ijmuiden'),
--       (1003, 'Manou',  'user', TRUE, 'info@manou.com',  'Manou', 'Kampweg 71', '6666CA', 'Swalmen');

--UPDATE users
--SET username = 'Frits',
--WHERE CustomerID = 1001;


--INSERT INTO authorities (username, authority)
--VALUES ('gebruiker', 'ROLE_USER'),
--       ('itiskevin', 'ROLE_USER'),
--       ('lmnadora', 'ROLE_USER'),
--       ('mengelmoestuintje', 'ROLE_USER'),
--       ('vivalanouk', 'ROLE_USER'),
--       ('mengelmoestuintje', 'ROLE_MODERATOR'),
--       ('vivalanouk', 'ROLE_MODERATOR'),
--       ('vivalanouk', 'ROLE_ADMIN');


