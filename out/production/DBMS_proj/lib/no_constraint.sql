

# Songs Table
delete  from song where  1=1;
INSERT INTO song (S_id, royalty_rate, release_country, title, duration, Royalty_paid,release_date)
VALUES
('s1001', 0.1, 'United States', 'Electric Dreamscape', 3.45, 'No','2022-01-12 09:18:57'),
('s1002', 0.1, 'United States', 'Midnight Mirage', 4.13, 'No','2022-01-12 09:18:57'),
('s1003', 0.1, 'United States', 'Echoes of You', 2.50, 'No','2022-01-12 09:18:57'),
('s1004', 0.1, 'United States', 'Rainy Nights', 4.15, 'No','2022-01-12 09:18:57');

/*Artists table*/
delete  from artists where  1=1;
INSERT INTO artists (Ar_id, name, primary_genre, status, country, monthly_listeners)
VALUE
('ar2001', 'Forest', 'pop', 'active', 'United States', 25),
('ar2002', 'Rain', 'pop', 'active', 'United States', 55);


/*record label according to the demo data*/
delete  from record_label where  1=1;
INSERT INTO record_label (Rl_id, name)
VALUES
('rl3001', 'Elevate Records'),
('rl3002', 'Melodic Avenue Music');

/*album table according to the demo data*/
delete  from album where  1=1;
INSERT INTO album (album_id, release_year, album_name, edition)
VALUES
('al4001', 2021, 'Electric Oasis', 'first'),
('al4002', 2022, 'Lost in the Echoes', 'first');

/*users table according to the demo data*/
delete  from users where  1=1;
INSERT INTO users (u_id, fname, lname, phone, email, reg_date, status, monthly_fee)
VALUES
('u8001','Alex','A','9199315287','alex@ncsu.edu','2022-01-12 09:18:57', 'active', 10.00),
('u8002','John','J','9199315278','john@ncsu.edu','2022-01-22 21:32:14', 'active', 10.00);

/*podcast according to the demo data*/
delete  from podcast where  1=1;
INSERT INTO podcast (pod_id, name, episode_count, country, language, rating, total_subs, flat_fee)
VALUES
('p5001','Mind Over Matter: Exploring the Power of the Human Mind', 5, 'United States','English', 4.5, 10, 10.0);

/*Podcast Host table*/
delete  from podcast_host where  1=1;
INSERT INTO podcast_host (host_id, f_name, l_name, email, phone, city)
VALUES
('ph6001', 'Matthew', 'Wilson', 'matwilson@gmail.com', '98828282992', 'Newyork');

/*podcast_episode according to the demo data*/
INSERT INTO podcast_episode (podEp_id, podEp_title, listenCount, ads_count, release_date,duration) VALUES
('pe7001','The Science of Mindfulness',100,0,'2022-01-05','00:09:12'),
('pe7002','Unlocking Your Potential',200,0,'2022-04-15','08:09:10');

# Genre table
delete  from genre where  1=1;
INSERT INTO genre(genre_id,genre)
VALUES
('gen001','Rock'),
('gen002','Pop'),
('gen003','Hip hop'),
('gen004','metal');

# /*Special guests table*/
delete  from special_guest where  1=1;
INSERT INTO special_guest (guest_id,guest_name)
VALUES
('guest001','Elon Musk'),
('guest002','Bill Gates'),
('guest003','Oprah Winfrey'),
('guest004','Stephen Hawking');

# /*Sponsor table*/
delete  from sponsors where  1=1;
INSERT INTO sponsors (sponsor_id,sponsor_name)
VALUES
('spon001','Netflix'),
('spon002','Pepsi'),
('spon003','Nike'),
('spon004','Apple');

delete  from podcast_episode where  1=1;
INSERT INTO podcast_episode (podEp_id, podEp_title, duration, listenCount, ads_count, Ad_rate, release_date) VALUES
('pe7001','The Science of Mindfulness','00:20:00',100,0, 10 ,'2022-01-05'),
('pe7002','Unlocking Your Potential','00:30:00',200,0, 10 ,'2022-04-15');






# /*Users table*/
# delete  from users where  1=1;
# ALTER TABLE users AUTO_INCREMENT = 1;
# INSERT INTO users (fname, lname, email, reg_date, status, monthly_fee, phone)
# VALUES
# ('Kevin', 'Smith', 'ksmith1@gmail.com', '2022-01-12 09:18:57', 'Active', 250, '123-456-7890'),
# ('Sarah', 'Johnson', 'sjohnson2@hotmail.com', '2022-01-22 21:32:14', 'Active', 250, '555-555-1212'),
# ('John', 'Doe', 'jdoe3@yahoo.com', '2022-01-07 14:49:23', 'Inactive', 0, '111-222-3333'),
# ('Emily', 'Taylor', 'etaylor4@gmail.com', '2022-01-15 17:02:33', 'Active', 250, '555-555-5555'),
# ('Megan', 'Smith', 'm.smith@gmail.com', '2022-01-01 08:30:45', 'Active', 250, '812-563-8911'),
# ('James', 'Johnson', 'jjohnson@hotmail.com', '2022-01-11 19:47:56', 'Inactive', 0, '707-333-9876'),
# ('Emily', 'Davis', 'emily.davis@yahoo.com', '2022-01-08 12:15:20', 'Active', 250, '415-786-9012');
#
# /*Songs table*/
# delete  from song where  1=1;
# ALTER TABLE song AUTO_INCREMENT = 1;
# INSERT INTO song (royalty_rate, release_country, release_date, title, duration, royalty_paid) VALUES
# (10.0, 'United States', '2022-01-03 20:57:48', 'Cold wind', 4.72, 'Yes'),
# (10.0, 'United States', '2022-01-12 15:32:10', 'Summer Nights', 3.45, 'Yes'),
# (10.0, 'United States', '2022-01-10 10:15:30', 'Riverside', 5.01, 'Yes'),
# (10.0, 'United States', '2022-01-04 08:22:52', 'Beach Party', 2.58, 'Yes'),
# (10.0, 'United States', '2022-01-15 12:40:21', 'Highway Blues', 3.82, 'No'),
# (10.0, 'United States', '2022-01-10 18:00:00', 'Sunny Day', 4.12, 'No');
#
#
# /*Albums table*/
# delete  from album where  1=1;
# ALTER TABLE album AUTO_INCREMENT = 1;
# INSERT INTO album (album_name, release_year, edition)
# VALUES
# ('Rock On', 2022, 5),
# ('Greatest Hits', 2022, 2),
# ('Pop Sensation', 2022, 3),
# ('Rhythm Nation', 2022, 1);
#
#
# /*Artists table*/
# delete  from artists where  1=1;
# ALTER TABLE artists AUTO_INCREMENT = 1;
# INSERT INTO artists(name, primary_genre, status, country, type)
# VALUES
# ('Maddy Otterwell', 'metal', 'Retired', 'United States', 'Band'),
# ('Josiah Matts', 'Pop', 'Active', 'United States', 'composer'),
# ('Dyana Leyson', 'Pop', 'Active', 'United States', 'musician'),
# ('Avery Ropes', 'Pop', 'Active', 'United States', 'singer'),
# ('Tara Bungay', 'Jazz', 'Retired', 'United States', 'Band');
#
# /*Record Label table*/
# delete  from record_label where  1=1;
# ALTER TABLE record_label AUTO_INCREMENT = 1;
# INSERT INTO record_label (name)
# VALUES
# ('Sony Music'),
# ('Universal Music'),
# ('Warner Music'),
# ('Atlantic Records'),
# ('Columbia Records');
#
# /*Genre table*/
# delete  from genre where  1=1;
# ALTER TABLE genre AUTO_INCREMENT = 1;
# INSERT INTO genre(genre)
# VALUES
# ('Rock'),
# ('Pop'),
# ('Hip hop'),
# ('metal'),
# ('Electronic'),
# ('Classical'),
# ('Jazz'),
# ('Country');
#
# /*Podcast table*/
# delete  from podcast where  1=1;
# ALTER TABLE podcast AUTO_INCREMENT = 1;
# INSERT INTO podcast (name, episode_count, country, language)
# VALUES
# ('The American Podcast', 2, 'United States', 'English'),
# ('The Daily Buzz', 2, 'United States', 'English'),
# ('The Storyteller USA', 2, 'United States', 'English'),
# ('Pundit Nation USA', 2, 'United States', 'English');
#
#
#
# /*Podcast Host table*/
# delete  from podcast_host where  1=1;
# ALTER TABLE podcast_host AUTO_INCREMENT = 1;
# INSERT INTO podcast_host (f_name, l_name, email, phone, city)
# VALUES
# ('Lez', 'Fridman', 'lezfredman@gmail.com', '869-822-7598', 'San Francisco'),
# ('Jovany', 'Spong', 'jovspong@gmail.com', '521-869-2665', 'New York'),
# ('Zalika', 'St Clair', 'zalikastclair@gmail.com', '643-278-9210', 'Los Angeles'),
# ('Luciano', 'Gerish', 'lucianogerish@gmail.com', '731-190-4559', 'Chicago'),
# ('Eilidh', 'Jeste', 'eilidhjeste@gmail.com', '567-827-3122', 'Houston'),
# ('Pio', 'de Cullip', 'piodecullip@gmail.com', '951-468-2843', 'Philadelphia');
#
# /*Special guests table*/
# delete  from special_guest where  1=1;
# ALTER TABLE special_guest AUTO_INCREMENT = 1;
# INSERT INTO special_guest (guest_name)
# VALUES
# ('Elon Musk'),
# ('Bill Gates'),
# ('Oprah Winfrey'),
# ('Stephen Hawking'),
# ('Angelina Jolie'),
# ('Barack Obama'),
# ('Beyonce Knowles'),
# ('Dalai Lama');
#
# /*Sponsor table*/
# delete  from sponsors where  1=1;
# ALTER TABLE sponsors AUTO_INCREMENT = 1;
# INSERT INTO sponsors (sponsor_name)
# VALUES
# ('Netflix'),
# ('Pepsi'),
# ('Nike'),
# ('Apple'),
# ('Samsung'),
# ('Amazon'),
# ('Toyota'),
# ('Honda');
#
