INSERT INTO my_database.album
(reg_date, title, update_date)
VALUES('2020-02-07 05:20:22.000', 'my album1', '2020-02-07 05:20:22.000');

INSERT INTO my_database.album
(reg_date, title, update_date)
VALUES('2020-02-07 05:20:23.000', 'my album2', '2020-02-07 05:20:23.000');


INSERT INTO my_database.album_locale
(locale, reg_date, update_date, album_id)
VALUES('all', '2020-02-07 05:20:22.000', '2020-02-07 05:20:22.000', 1);
INSERT INTO my_database.album_locale
(locale, reg_date, update_date, album_id)
VALUES('kr', '2020-02-07 05:20:23.000', '2020-02-07 05:20:23.000', 2);
INSERT INTO my_database.album_locale
(locale, reg_date, update_date, album_id)
VALUES('en', '2020-02-07 05:20:23.000', '2020-02-07 05:20:23.000', 2);

INSERT INTO my_database.song
(`length`, reg_date, title, track, update_date, album_id)
VALUES(300, '2020-02-07 05:20:22.000', 'my album1 - 1', 1, '2020-02-07 05:20:22.000', 1);
INSERT INTO my_database.song
(`length`, reg_date, title, track, update_date, album_id)
VALUES(300, '2020-02-07 05:20:22.000', 'my album1 - 2', 1, '2020-02-07 05:20:22.000', 1);
INSERT INTO my_database.song
(`length`, reg_date, title, track, update_date, album_id)
VALUES(300, '2020-02-07 05:20:23.000', 'my album2 - 1', 1, '2020-02-07 05:20:23.000', 2);

INSERT INTO my_database.user_playlist
(reg_date, title, update_date, user_id)
VALUES('2020-02-07 05:20:23.000', 'user 1''s playlist1', '2020-02-07 05:20:23.000', 1);
INSERT INTO my_database.user_playlist
(reg_date, title, update_date, user_id)
VALUES('2020-02-07 05:20:23.000', 'user 1''s playlist2', '2020-02-07 05:20:23.000', 1);
INSERT INTO my_database.user_playlist
(reg_date, title, update_date, user_id)
VALUES('2020-02-07 05:20:23.000', 'user 2''s playlist1', '2020-02-07 05:20:23.000', 2);

INSERT INTO my_database.user_playlist_song
(reg_date, update_date, song_id, user_playlist_id)
VALUES('2020-02-07 05:20:23.000', '2020-02-07 05:20:23.000', 1, 1);
INSERT INTO my_database.user_playlist_song
(reg_date, update_date, song_id, user_playlist_id)
VALUES('2020-02-07 05:20:23.000', '2020-02-07 05:20:23.000', 2, 1);
INSERT INTO my_database.user_playlist_song
(reg_date, update_date, song_id, user_playlist_id)
VALUES('2020-02-07 05:20:23.000', '2020-02-07 05:20:23.000', 3, 2);
INSERT INTO my_database.user_playlist_song
(reg_date, update_date, song_id, user_playlist_id)
VALUES('2020-02-07 05:20:23.000', '2020-02-07 05:20:23.000', 2, 3);
