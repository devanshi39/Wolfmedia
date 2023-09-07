delete  from song_play where  1=1;
INSERT INTO song_play (S_id, play_count, month_year)
VALUES
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

delete  from sungBy where  1=1;
INSERT INTO sungBy (Ar_id, S_id, is_collaborator)
VALUES
('ar2001', 's1001', 0),
('ar2001', 's1002', 0),
('ar2002', 's1002', 1),
('ar2002', 's1003', 0),
('ar2002', 's1004', 0);


/*Album_song according to the demo data*/
delete  from Album_song where  1=1;
INSERT INTO Album_song (album_id, S_id, t_no)
VALUES
('al4001', 's1001', 1),
('al4001', 's1002', 1),
('al4002', 's1003', 1),
('al4002', 's1004', 1);

/*Artist_album according to the demo data*/
delete  from Artist_album where  1=1;
INSERT INTO Artist_album (Ar_id,album_id)
VALUES
('ar2001', 'al4001'),
('ar2002', 'al4001');

/*RL_Artist according to the demo data*/
delete  from RL_Artist where  1=1;
INSERT INTO RL_Artist (Rl_id, Ar_id)
VALUES
('rl3001', 'ar2001'),
('rl3002', 'ar2002');

/*owns according to the demo data*/
delete  from owns where  1=1;
INSERT INTO owns(S_id, Rl_id)
VALUES
('s1001', 'rl3001'),
('s1002', 'rl3001'),
('s1003', 'rl3002'),
('s1004', 'rl3002');

delete  from Pay_Ar where  1=1;
INSERT INTO Pay_Ar (Ar_id,Rl_id, Amount, Time_stamp)
VALUES
('ar2001','rl3001', 4.2, '2023-01-02 01:18:30'),
('ar2001','rl3001', 8.4, '2023-02-02 01:18:30'),
('ar2001','rl3001', 12.6,'2023-03-02 01:18:30'),
('ar2002','rl3002', 703.5, '2023-01-02 01:18:30'),
('ar2002','rl3002', 1547, '2023-03-02 01:18:30'),
('ar2002','rl3002', 2320.5, '2023-03-02 01:18:30');


delete  from Pay_PH where  1=1;
INSERT INTO Pay_PH (host_id, amount, time_stamp, payment_ID)
VALUES
('ph6001' , 20, '2023-01-02 08:30:00', '433100'),
('ph6001', 30, '2023-02-02 08:30:00', '433101'),
('ph6001', 40, '2023-03-02 08:30:00', '433102');

delete  from Pay_User where  1=1;
INSERT INTO Pay_User (u_id, payment_id, time_stamp, Amount)
VALUES
('u8001', '433124', '2023-01-05 09:30:00', 10),
('u8002', '433115', '2023-01-05 09:30:00', 10),
('u8001', '433111', '2023-02-05 09:30:00', 10),
('u8002', '433198', '2023-02-05 09:30:00', 10),
('u8001', '433167', '2023-03-05 09:30:00', 10),
('u8002', '433101', '2023-03-05 09:30:00', 10);


delete  from Pay_RL where  1=1;
INSERT INTO Pay_RL (RL_id, amount, time_stamp, payment_ID)
VALUES
('rl3001' , 3.3, '2023-01-02 08:30:00', '433107'),
('rl3001' , 6.6, '2023-02-02 08:30:00', '432107'),
('rl3001' , 9.9, '2023-03-02 08:30:00', '434107'),
('rl3002' , 330, '2023-01-02 08:30:00', '435107'),
('rl3002' , 660, '2023-02-02 08:30:00', '433109'),
('rl3002' , 990, '2023-03-02 08:30:00', '433120');


delete  from pod_host where  1=1;
INSERT INTO pod_host (pod_id, host_id)
VALUES
('p5001', 'ph6001');

delete  from has where  1=1;
INSERT INTO has (pod_id, podEp_id) VALUES
('p5001','pe7001'),
('p5001','pe7002');






















# /* Wolfmedia payments table*/
# delete  from Wolfmedia where  1=1;
# INSERT INTO Wolfmedia (payment_id, category)
# VALUES
# (433100, 'Podcast Host'),
# (433101, 'Podcast Host'),
# (433102, 'Podcast Host'),
# (433103, 'Podcast Host'),
# (433104, 'Podcast Host'),
# (433105, 'Podcast Host'),
# (433106, 'Podcast Host'),
# (433107, 'Record Label'),
# (433108, 'Record Label'),
# (433109, 'Record Label'),
# (433110, 'Record Label'),
# (433111, 'Record Label'),
# (433112, 'Record Label'),
# (433113, 'Record Label'),
# (433114, 'Record Label'),
# (433115, 'User'),
# (433116, 'User'),
# (433117, 'User'),
# (433118, 'User'),
# (433119, 'User'),
# (433120, 'User'),
# (433121, 'User'),
# (433122, 'User'),
# (433123, 'User'),
# (433124, 'User');
#
# /*Artist Album table*/
# delete  from Artist_album where  1=1;
# INSERT INTO Artist_album (Ar_id, album_id)
# VALUES
# (1,1),
# (2,2),
# (3,3),
# (4,4),
# (5,4);
#
# /*Album song table*/
# delete  from Album_song where  1=1;
# INSERT INTO Album_song(album_id, s_id, t_no)
# VALUES
# (1, 1, 1),
# (2, 2, 1),
# (3, 3, 1),
# (4, 4, 1),
# (4, 5, 2),
# (4, 6, 3);
#
# /*Sung By table*/
# delete  from sungBy where  1=1;
# INSERT INTO sungBy(Ar_id,S_id,is_collaborator)
# VALUES
# (1, 1, false),
# (2, 1, true),
# (2, 2, false),
# (3, 3, false),
# (4, 4, false),
# (5, 5,false),
# (5, 6, false);
#
# /*Record label artist table*/
# delete  from RL_Artist where  1=1;
# INSERT INTO RL_Artist(RL_id, Ar_id, Created_at)
# VALUES
# (1, 1, '2021-12-01 08:30:00'),
# (2, 2, '2021-12-03 11:30:00'),
# (3, 3, '2021-12-04 12:30:00'),
# (4, 4, '2021-12-05 13:30:00'),
# (4, 5, '2021-12-05 13:30:00');
#
# select * from RL_Artist
# /*Owns table*/
# delete  from owns where  1=1;
# INSERT INTO owns(S_id,RL_id)
# VALUES
# (1, 1),
# (2, 2),
# (3, 3),
# (4, 3),
# (5, 4),
# (6, 4);
#
# /*Song genre table*/
# delete  from song_genre where  1=1;
# INSERT INTO song_genre(S_id,genre_id)
# VALUES
# (1, 1),
# (2, 2),
# (3, 3),
# (4, 4),
# (5, 5),
# (6, 5);
#
# /*Artist Sub table*/
# delete  from Artist_sub where  1=1;
# INSERT INTO Artist_sub (u_id, Ar_id, timestamp)
# VALUES
# (1, 4, '2022-02-12 14:32:19'),
# (1, 2, '2022-03-12 14:32:19'),
# (1, 3, '2022-04-12 14:32:19'),
# (2, 5, '2022-02-23 07:45:10'),
# (3, 5, '2022-03-05 18:12:34'),
# (4, 1, '2022-03-15 21:09:42'),
# (5, 3, '2022-03-25 10:30:56'),
# (3, 2, '2022-04-05 18:12:34'),
# (4, 3, '2022-05-15 21:09:42'),
# (5, 4, '2022-06-25 10:30:56');
#
# /*Listens table*/
# delete  from Listens where  1=1;
# INSERT INTO Listens (u_id, S_id, timestamp)
# VALUES
# (1, 4, '2022-01-29 09:12:00'),
# (3, 2, '2022-02-27 16:45:00'),
# (2, 6, '2022-01-28 12:20:00'),
# (4, 1, '2022-02-27 20:15:00'),
# (3, 5, '2022-02-27 08:00:00'),
# (1, 3, '2022-01-28 18:30:00'),
# (4, 1, '2022-02-27 20:15:00'),
# (3, 3, '2022-01-27 08:00:00'),
# (1, 3, '2022-01-29 18:30:00'),
# (2, 4, '2022-02-26 11:45:00'),
# (4, 2, '2022-01-16 20:15:00'),
# (4, 6, '2022-01-30 16:10:00'),
# (5, 1, '2022-02-27 20:15:00'),
# (5, 3, '2022-01-27 08:00:00'),
# (6, 3, '2022-01-29 18:30:00'),
# (6, 4, '2022-02-26 11:45:00'),
# (7, 2, '2022-01-16 20:15:00'),
# (5, 1, '2022-01-23 20:15:00'),
# (7, 5, '2022-01-09 20:15:00'),
# (1, 3, '2022-02-16 20:15:00'),
# (2, 6, '2022-02-07 20:15:00'),
# (7, 6, '2022-01-30 16:10:00');
#
# /*recordLabelPayment table*/
# delete  from Pay_RL where  1=1;
# INSERT INTO Pay_RL (RL_id, amount, timestamp, payment_ID)
# VALUES
# (1, 10, '2022-02-01 08:30:00', 433107),
# (1, 30, '2022-03-01 08:30:00', 433108),
# (2, 20, '2022-02-01 08:30:00', 433109),
# (2, 10, '2022-03-01 08:30:00', 433110),
# (3, 50, '2022-02-01 08:30:00', 433111),
# (3, 10, '2022-03-01 08:30:00', 433112),
# (4, 50, '2022-02-01 08:30:00', 433113),
# (4, 40, '2022-03-01 08:30:00', 433114);
#
# /*Artist Payment table*/
# delete  from Pay_Ar where  1=1;
# INSERT INTO Pay_Ar(RL_id,Ar_id, amount, timestamp)
# VALUES
# (1, 1, 7,'2022-04-01 09:30:00'),
# (2, 2, 14,'2022-04-01 12:30:00'),
# (3, 3, 21,'2022-04-01 13:30:00'),
# (4, 4, 28,'2022-04-01 14:30:00'),
# (4, 5, 28,'2022-04-01 14:30:00');
#
#
# /*Podcast table*/
# delete  from Pod_sub where  1=1;
# INSERT INTO Pod_sub (u_id, pod_id, timestamp)
# VALUES
# (1, 4, '2022-03-01 08:30:00'),
# (2, 2, '2022-02-28 14:45:00'),
# (3, 3, '2022-02-27 10:15:00'),
# (4, 1, '2022-03-02 09:00:00'),
# (5, 2, '2022-03-01 16:30:00'),
# (6, 3, '2022-03-02 13:45:00'),
# (7, 4, '2022-02-28 18:00:00');
#
#
# /*Rating table*/
# delete  from Rates where  1=1;
# INSERT INTO Rates (u_id, pod_id, rating)
# VALUES
# (1, 1, 4.0),
# (1, 2, 3.5),
# (1, 3, 4.5),
# (2, 4, 2.0),
# (2, 1, 4.2),
# (2, 2, 3.0),
# (3, 3, 3.0),
# (4, 4, 4.2),
# (5, 1, 3.0),
# (5, 2, 2.0),
# (5, 3, 4.2),
# (6, 4, 3.0),
# (3, 1, 3.0);
#
# /* podcast episode table*/
# delete  from podcast_episode where  1=1;
# INSERT INTO podcast_episode (pod_id, title, duration, ads_count, release_date)
# VALUES
# (1, 'The American Podcast: ep1', '00:20:00', 2, '2022-01-10 08:30:00'),
# (1, 'The American Podcast: ep2', '00:30:00', 3, '2022-02-10 08:30:00'),
# (2, 'The Daily Buzz: ep1', '00:20:00', 2, '2022-01-08 09:30:00'),
# (2, 'The Daily Buzz: ep2', '00:22:00', 2,'2022-02-15 09:30:00'),
# (3, 'The Storyteller USA: ep1', '00:25:00', 3, '2022-01-18 09:30:00'),
# (3, 'The Storyteller USA: ep2', '00:25:00', 3, '2022-02-18 09:30:00'),
# (4, 'Pundit Nation USA: ep1', '00:30:00', 2,'2022-01-20 09:30:00'),
# (4, 'Pundit Nation USA: ep2', '00:30:00', 3,'2022-02-20 09:30:00');
#
# /* podcast host table*/x
# INSERT INTO pod_host(pod_id, host_id)
# VALUES
# (1,1),
# (2,2),
# (3,3),
# (4,4);
#
# /* podcastHostPayment TABLE flat fee = 50 and 10 for each add */
#
# delete  from Pay_User where  1=1;
# INSERT INTO Pay_User (u_id, payment_id, timestamp, Amount)
# VALUES
# (1, 433124, '2022-01-05 09:30:00', 50),
# (2, 433115, '2022-01-05 09:30:00', 50),
# (3, 433116, '2022-01-05 09:30:00', 50),
# (3, 433117, '2022-02-05 09:30:00', 50),
# (4, 433118, '2022-01-05 09:30:00', 50),
# (4, 433119, '2022-02-05 09:30:00', 50),
# (5, 433120, '2022-02-05 09:30:00', 50),
# (6, 433121, '2022-01-05 09:30:00', 50),
# (6, 433122, '2022-02-05 09:30:00', 50),
# (7, 433123, '2022-02-05 09:30:00', 50);
# delete  from Pay_PH where  1=1;
# INSERT INTO Pay_PH (host_id, amount, timestamp, payment_ID)
# VALUES
#     (1, 15, '2022-01-10 08:30:00', 433100),
#     (1, 15, '2022-02-10 08:30:00', 433101),
#     (2, 15, '2022-01-11 08:30:00', 433102),
#     (2, 15, '2022-02-25 08:30:00', 433103),
#     (3, 15, '2022-01-14 08:30:00', 433104),
#     (3, 15, '2022-02-10 08:30:00', 433104),
#     (4, 15, '2022-01-06 08:30:00', 433105),
#     (4, 15, '2022-02-26 08:30:00', 433106);
#
# /* episode guest */
# delete  from episode_guest where  1=1;
# INSERT INTO episode_guest(pod_id, title, guest_id)
# VALUES
#     (1, 'The American Podcast: ep1', 1),
#     (1, 'The American Podcast: ep2', 2),
#     (2, 'The Daily Buzz: ep1', 6),
#     (3, 'The Storyteller USA: ep1', 3);
#
# # Podcast Genre
# delete  from podcast_genre where  1=1;
# insert into podcast_genre (genre_id, pod_id)
# values
#     (1, 1),
#     (2, 2),
#     (3, 3),
#     (4, 4),
#     (3, 1),
#     (4, 2),
#     (2, 3),
#     (1, 4);
#
#
# delete  from podcast_sponsor where  1=1;
# insert into podcast_sponsor (pod_id, sponsor_id)
# values
#     (1, 1),
#     (2, 2),
#     (3, 3),
#     (4, 4),
#     (3, 1),
#     (4, 2),
#     (2, 3),
#     (1, 4);
#
# delete  from hears where  1=1;
# INSERT INTO hears (u_id, pod_id, title, timestamp)
# VALUES
#     (1,1,'The American Podcast: ep1','2022-01-11 09:30:00'),
#     (1,1,'The American Podcast: ep2', '2022-02-12 10:30:00'),
#     (2,2,'The Daily Buzz: ep1','2022-01-10 07:30:00'),
#     (2,2,'The Daily Buzz: ep2','2022-02-17 09:30:00'),
#     (3,3, 'The Storyteller USA: ep1', '2022-01-18 11:30:00'),
#     (3,3, 'The Storyteller USA: ep2', '2022-02-19 10:30:00'),
#     (4,4, 'Pundit Nation USA: ep1', '2022-01-20 10:30:00'),
#     (4,4, 'Pundit Nation USA: ep2', '2022-02-20 10:30:00'),
#     (5,1,'The American Podcast: ep1','2022-01-11 11:30:00'),
#     (5,1,'The American Podcast: ep2', '2022-02-12 12:30:00'),
#     (6,2,'The Daily Buzz: ep1','2022-01-11 07:30:00'),
#     (6,2,'The Daily Buzz: ep2','2022-02-18 09:30:00'),
#     (1,3, 'The Storyteller USA: ep1', '2022-01-20 11:30:00'),
#     (1,3, 'The Storyteller USA: ep2', '2022-02-20 10:30:00'),
#     (2,4, 'Pundit Nation USA: ep1', '2022-01-20 11:30:00'),
#     (2,4, 'Pundit Nation USA: ep2', '2022-02-20 12:30:00');