--No Constraint tables
/*song table according to demo data*/
delete  from song where  1=1;
INSERT INTO song (S_id, royalty_rate, release_country, title, duration, Royalty_paid,release_date)
VALUES
('s1001', 0.1, 'United States', 'Electric Dreamscape', 3.45, 'No','2022-01-12 09:18:57'),
('s1002', 0.1, 'United States', 'Midnight Mirage', 4.13, 'No','2022-01-12 09:18:57'),
('s1003', 0.1, 'United States', 'Echoes of You', 2.50, 'No','2022-01-12 09:18:57'),
('s1004', 0.1, 'United States', 'Rainy Nights', 4.15, 'No','2022-01-12 09:18:57');


/*artists table according to the demo data*/
delete  from artists where  1=1;
INSERT INTO artists (Ar_id, name, primary_genre, status, country, monthly_listeners, type) VALUES
('ar2001', 'Forest', 'pop', 'active', 'United States', 25,'musician'),
('ar2002', 'Rain', 'pop', 'active', 'United States', 55,'musician');


/*record label according to the demo data*/
delete  from record_label where  1=1;
INSERT INTO record_label (Rl_id, name) VALUES
('rl3001', 'Elevate Records'),
('rl3002', 'Melodic Avenue Music');

/*album table according to the demo data*/
delete  from album where  1=1;
INSERT INTO album (album_id, release_year, album_name, edition) VALUES
('al4001', 2021, 'Electric Oasis', 'first'),
('al4002', 2022, 'Lost in the Echoes', 'first');

/*users according to the demo data*/
delete  from users where  1=1;
INSERT INTO users (u_id, fname, lname, phone, email, reg_date, status, monthly_fee) VALUES
('u8001','Alex','A','9199315287','alex@ncsu.edu','2022-01-12 09:18:57', 'active', 10.00),
('u8002','John','J','9199315278','john@ncsu.edu','2022-01-22 21:32:14', 'active', 10.00);

/*podcast according to the demo data*/
delete  from podcast where  1=1;
INSERT INTO podcast (pod_id, name, episode_count, country, language, rating, total_subs, flat_fee) VALUES
('p5001','Mind Over Matter: Exploring the Power of the Human Mind', 5, 'United States','English', 4.5, 10, 10.0);

/*podcast_host according to the demo data*/
delete  from podcast_host where  1=1;
INSERT INTO podcast_host (host_id, email, f_name, l_name, phone, city) VALUES
('ph6001','matwil@ncsu.edu','Matthew','Wilson','9987623923','New York');

/*podcast_episode according to the demo data*/
delete  from podcast_episode where  1=1;
INSERT INTO podcast_episode (podEp_id, podEp_title, listenCount, ads_count, release_date, duration, Ad_rate) VALUES
('pe7001','The Science of Mindfulness',100,0,'2022-01-05','00:09:12',0),
('pe7002','Unlocking Your Potential',200,0,'2022-04-15','08:09:10',0);




--Constraint tables
/*song_play table according to the demo data*/
delete  from song_play where  1=1;
INSERT INTO song_play (S_id, play_count, month_year) VALUES
('s1001', 10, '2023-01-02 01:18:30'),
('s1001', 20, '2023-02-02 01:18:30'),
('s1001', 30, '2023-03-02 01:18:30'),
('s1001', 1000, '2023-04-02 01:18:30'),
('s1002', 100, '2023-01-02 01:18:30'),
('s1002', 200, '2023-02-02 01:18:30'),
('s1002', 300, '2023-03-02 01:18:30'),
('s1002', 1000, '2023-04-02 01:18:30'),
('s1003', 1000, '2023-01-02 01:18:30'),
('s1003', 2000, '2023-02-02 01:18:30'),
('s1003', 3000, '2023-03-02 01:18:30'),
('s1003', 100, '2023-04-02 01:18:30'),
('s1004', 10000, '2023-01-02 01:18:30'),
('s1004', 20000, '2023-02-02 01:18:30'),
('s1004', 30000, '2023-03-02 01:18:30'),
('s1004', 200, '2023-04-02 01:18:30');

/*sungBy according to the demo data*/
delete  from sungBy where  1=1;
INSERT INTO sungBy (Ar_id, S_id, is_collaborator) VALUES
('ar2001', 's1001', 0),
('ar2001', 's1002', 0),
('ar2002', 's1002', 1),
('ar2002', 's1003', 0),
('ar2002', 's1004', 0);

/*Album_song according to the demo data*/
delete  from Album_song where  1=1;
INSERT INTO Album_song (album_id, S_id, t_no) VALUES
('al4001', 's1001', 1),
('al4001', 's1002', 2),
('al4002', 's1003', 1),
('al4002', 's1004', 2);

/*Artist_album according to the demo data*/
delete  from Artist_album where  1=1;
INSERT INTO Artist_album (Ar_id,album_id) VALUES
('ar2001', 'al4001'),
('ar2002', 'al4001');

/*RL_Artist according to the demo data*/
delete  from RL_Artist where  1=1;
INSERT INTO RL_Artist (Rl_id, Ar_id) VALUES
('rl3001', 'ar2001'),
('rl3002', 'ar2002');

/*owns according to the demo data*/
delete  from owns where  1=1;
INSERT INTO owns(S_id, Rl_id) VALUES
('s1001', 'rl3001'),
('s1002', 'rl3001'),
('s1003', 'rl3002'),
('s1004', 'rl3002');

/*Pay_Ar according to the demo data*/
delete  from Pay_Ar where  1=1;
INSERT INTO Pay_Ar (Rl_id, Ar_id, Amount, Time_stamp) VALUES
('rl3001','ar2001', 4.2, '2023-01-02 01:18:30'),
('rl3001','ar2001', 8.4, '2023-02-02 01:18:30'),
('rl3001','ar2001', 12.6, '2023-03-02 01:18:30'),
('rl3002','ar2002', 703.5, '2023-01-02 01:18:30'),
('rl3002','ar2002', 1547, '2023-03-02 01:18:30'),
('rl3002','ar2002', 2320.5, '2023-03-02 01:18:30');

/*Pay_PH according to the demo data*/
delete  from Pay_PH where  1=1;
INSERT INTO Pay_PH (host_id, amount, time_stamp, payment_ID)
VALUES
('ph6001' , 20, '2023-01-02 08:30:00', '433100'),
('ph6001', 30, '2023-02-02 08:30:00', '433101'),
('ph6001', 40, '2023-03-02 08:30:00', '433102');

/*Pay_User according to the demo data*/
delete  from Pay_User where  1=1;
INSERT INTO Pay_User (u_id, payment_id, time_stamp, Amount)
VALUES
('u8001', '433124', '2023-01-05 09:30:00', 10),
('u8002', '433115', '2023-01-05 09:30:00', 10),
('u8001', '433111', '2023-02-05 09:30:00', 10),
('u8002', '433198', '2023-02-05 09:30:00', 10),
('u8001', '433167', '2023-03-05 09:30:00', 10),
('u8002', '433101', '2023-03-05 09:30:00', 10);

/*Pay_RL according to the demo data*/
delete  from Pay_RL where  1=1;
INSERT INTO Pay_RL (RL_id, amount, time_stamp, payment_ID)
VALUES
('rl3001' , 3.3, '2023-01-02 08:30:00', '433107'),
('rl3001' , 6.6, '2023-02-02 08:30:00', '432107'),
('rl3001' , 9.9, '2023-03-02 08:30:00', '434107'),
('rl3002' , 330, '2023-01-02 08:30:00', '435107'),
('rl3002' , 660, '2023-02-02 08:30:00', '433109'),
('rl3002' , 990, '2023-03-02 08:30:00', '433120');

/*pod_host according to the demo data*/
delete  from pod_host where  1=1;
INSERT INTO pod_host (pod_id, host_id) VALUES
('p5001', 'ph6001');

/*has according to the demo data*/
delete  from has where  1=1;
INSERT INTO has (pod_id, podEp_id) VALUES
('p5001','pe7001'),
('p5001','pe7002');
