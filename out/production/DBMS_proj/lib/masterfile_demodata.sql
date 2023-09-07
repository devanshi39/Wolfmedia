/*song table according to demo data*/
INSERT INTO song (S_id, royalty_rate, release_country, title, duration, Royalty_paid) VALUES
('s1001', 0.1, 'United States', 'Electric Dreamscape', 3.45, 'No'),
('s1002', 0.1, 'United States', 'Midnight Mirage', 4.13, 'No'),
('s1003', 0.1, 'United States', 'Echoes of You', 2.50, 'No'),
('s1004', 0.1, 'United States', 'Rainy Nights', 4.15, 'No');

/*song_play table according to the demo data*/
INSERT INTO song_play (S_id, play_count, month_year) VALUES
('s1001', 10, 'Jan'),
('s1001', 20, 'Feb'),
('s1001', 30, 'Mar'),
('s1001', 1000, 'April'),
('s1002', 100, 'Jan'),
('s1002', 200, 'Feb'),
('s1002', 300, 'Mar'),
('s1002', 1000, 'April'),
('s1003', 1000, 'Jan'),
('s1003', 2000, 'Feb'),
('s1003', 3000, 'Mar'),
('s1003', 100, 'April'),
('s1004', 10000, 'Jan'),
('s1004', 20000, 'Feb'),
('s1004', 30000, 'Mar'),
('s1004', 200, 'April');


/*artists table according to the demo data*/
INSERT INTO artists (Ar_id, name, primary_genre, status, country, monthly_listeners) VALUES
('ar2001', 'Forest', 'pop', 'active', 'United States', 25),
('ar2002', 'Rain', 'pop', 'active', 'United States', 55);


/*record label according to the demo data*/
INSERT INTO record_label (Rl_id, name) VALUES
('rl3001', 'Elevate Records'),
('rl3002', 'Melodic Avenue Music');

/*album table according to the demo data*/
INSERT INTO album (album_id, release_year, album_name, edition) VALUES
('al4001', 2021, 'Electric Oasis', 'first'),
('al4002', 2022, 'Lost in the Echoes', 'first');

/*sungBy according to the demo data*/
INSERT INTO sungBy (Ar_id, S_id, is_collaborator) VALUES
('ar2001', 's1001', 0),
('ar2001', 's1002', 0),
('ar2002', 's1002', 1),
('ar2002', 's1003', 0),
('ar2002', 's1004', 0);

/*Album_song according to the demo data*/
INSERT INTO Album_song (album_id, S_id, t_no) VALUES
('al4001', 's1001', 1),
('al4001', 's1002', 1),
('al4002', 's1003', 1),
('al4002', 's1004', 1);

/*Artist_album according to the demo data*/
INSERT INTO Artist_album ('Ar_id','album_id') VALUES
('ar2001', 'al4001'),
('ar2002', 'al4001');

/*RL_Artist according to the demo data*/
INSERT INTO RL_Artist (Rl_id, Ar_id) VALUES
('rl3001', 'ar2001'),
('rl3002', 'ar2002');

/*owns according to the demo data*/
INSERT INTO owns(S_id, Rl_id) VALUES
('s1001', 'rl3001'),
('s1002', 'rl3001'),
('s1003', 'rl3002'),
('s1004', 'rl3002');

