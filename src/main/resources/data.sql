INSERT INTO travels (id, country, years, city, category, description, duration)
VALUES (1001, 'France', 2010, 'Lons Le Saunier', 'Summer holiday', '8 day tour by car through the Jura in France', 8),
       (1002, 'Czech Republic', 2011, 'Prague and Cheb', 'Summer holiday', 'Visited Prague, Cheb and surrounding area', 12),
       (1003, 'Netherlands', 2011, 'Groenlo', 'Weekend trip', 'Visited Groenlo', 4),
       (1004, 'Germany', 2012, 'Berlin', 'Summer holiday', 'Visited Berlin and surrounding area', 11),
       (1005, 'Netherlands', 2012, 'Oisterwijk', 'Weekend trip', 'Holiday park in Oisterwijk', 4),
       (1006, 'Portugal', 2013, 'Olhao', 'Summer holiday', 'South coast of Portugal and went on a day trip to Spain', 7),
       (1007, 'Czech Republic', 2014, 'Ceske Budejovice', 'Work trip', 'Delivered and collected new gambling machines', 2),
       (1008, 'United Kingdom', 2014, 'Coventry', 'Work trip', 'Plain broke down so had to deliver with the van', 2),
       (1009, 'Italy', 2014, 'Pietra Ligure', 'Summer Holiday', 'Visited the Mediterranean Sea', 12),
       (1010, 'Belgium', 2014, 'Coo', 'Day trip', 'Visited the Falls of Coo', 1),
       (1011, 'Latvia', 2014, 'Riga', 'City trip', 'City trip to Riga', 4),
       (1012, 'Belgium', 2015, 'Atlantic Wall', 'Day trip', 'Day trip to the Atlantic wall in Belgium', 1),
       (1013, 'Belgium', 2015, 'Chateau Mirinda', 'Day trip', 'Urbex to one of the best spooky castles', 1),
       (1014, 'Czech Republic', 2015, 'Brno and Cheb and Bratislava', 'Summer trip', 'Road trip trough Czech Republic and visited Bratislava, Slovakia', 16),
       (1015, 'Germany', 2015, 'Cologne', 'City trip', 'City trip to Cologne', 3),
       (1016, 'Germany', 2016, 'Monschau', 'Road trip', 'Escaped carnaval only to find out they also celebrate carnaval', 7),
       (1017, 'Germany', 2016, 'Berlin', 'City trip', 'Party weekend Berlin', 2),
       (1018, 'Italy', 2016, 'Rome', 'City trip', 'Moms birthday surprise', 5),
       (1019, 'Austria and Slovenia and Croatia and Germany', 2016, 'multiple', 'Summer holiday', 'Road trip and overnights in Saint Gilgen, Portoroz, Umag, Porec and Dachau', 16),
       (1020, 'Australia and Asia', 2017, 'multiple', 'Backpacking', 'Worked and travelled through the whole of Australia and went on holiday to: Indonesia, Singapore, Malaysia, Thailand and Japan', 741),
       (1021, 'Estonia', 2019, 'Talinn', 'City trip', 'Visited friends and the beautiful Talinn', 4),
       (1022, 'Malta', 2020, 'St Pauls Bay', 'Spring break', 'Toured around the whole island', 8),
       (1023, 'Luxembourg', 2021, 'Luxembourg', 'Day trip', 'Hiking in the bush', 1),
       (1024, 'Tanzania', 2021, 'Dar es Salaam', 'Summer holiday', 'First time Africa and Safari tour', 12),
       (1025, 'France', 2022, 'Paris', 'City trip', 'City trip to Paris', 3),
       (1026, 'France', 2022, 'Marseille to Monaco', 'Road trip', 'Road trip to Marseille, St Tropes and Monaco, along the south cost of France ', 5);



INSERT INTO future_travels (id, country, area, category, duration, costs)
VALUES (1001, 'Costa Rica', 'country', 'Road trip', 21, 5000),
       (1002, 'USA', 'West Coast', 'Road trip', 21, 6000),
       (1003, 'Spain', 'Barcelona', 'City trip', 4, 500),
       (1004, 'China', 'Beijing', 'Summer holiday', 14, 4000);


INSERT INTO travel_tips (id, name, country, city, description)
VALUES (1001, 'Awesome experience', 'Costa Rica', 'San Jose', 'Nice city center'),
       (1002, 'Frikandellen', 'Australia', 'Melbourne', 'We used to buy Frikandellen at the Dutch shop'),
       (1003, 'Angkor Wat', 'Colombia', 'Siem Reap area', 'Amazing temples taken over by the jungle');








--INSERT INTO users (id, username, password, enabled, email, name, street, houseNumber, zipcode, city, preferences)
--VALUES (1001, 'TravelNerd', 'user', TRUE, 'info@travelnerd.com',  'Bas', 'Pietjepukweg, 71, '1234AA', 'Groningen', 'Road trip'),
--       (1002, 'Kasper', 'user', TRUE, 'info@kasper.nl', 'Kasper', 'Puinhoop 5', '8008SS', 'IJmuiden'),
--       (1003, 'Manou',  'user', TRUE, 'info@manou.com',  'Manou', 'Kampweg 71', '6666CA', 'Swalmen');

--UPDATE users
--SET username = 'Frits',
--WHERE UsersID = 1001;


--INSERT INTO authorities (username, authority)
--VALUES ('', 'ROLE_USER'),
--       ('', 'ROLE_USER'),
--       ('', 'ROLE_USER'),
--       ('', 'ROLE_USER'),
--       ('', 'ROLE_USER'),
--       ('', 'ROLE_MODERATOR'),
--       ('', 'ROLE_MODERATOR'),
--       ('', 'ROLE_ADMIN');


