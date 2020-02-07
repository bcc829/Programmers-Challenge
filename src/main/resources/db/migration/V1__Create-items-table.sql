create table my_database.album (
       id bigint not null auto_increment,
        reg_date datetime,
        title varchar(255) not null,
        update_date datetime,
        primary key (id)
);

create table my_database.album_locale (
   id bigint not null auto_increment,
    locale varchar(255) not null,
    reg_date datetime,
    update_date datetime,
    album_id bigint,
    primary key (id)
);

create table my_database.song (
       id bigint not null auto_increment,
        length integer not null,
        reg_date datetime,
        title varchar(255) not null,
        track integer not null,
        update_date datetime,
        album_id bigint,
        primary key (id)
);

create table my_database.user_playlist (
       id bigint not null auto_increment,
        reg_date datetime,
        title varchar(255) not null,
        update_date datetime,
        user_id bigint not null,
        primary key (id)
);

create table my_database.user_playlist_song (
       id bigint not null auto_increment,
        reg_date datetime,
        update_date datetime,
        song_id bigint,
        user_playlist_id bigint,
        primary key (id)
);

alter table my_database.album_locale
       add constraint FKrjririy42sgule6x0jewodvgg
       foreign key (album_id)
       references album (id);

alter table my_database.song
   add constraint FKrcjmk41yqj3pl3iyii40niab0
   foreign key (album_id)
   references album (id);

alter table my_database.user_playlist_song
   add constraint FKp3x0lgsyl9egwx2s7755sbkja
   foreign key (song_id)
   references song (id);

alter table my_database.user_playlist_song
   add constraint FKcsovbe27ggi9ofjs3a48yvo47
   foreign key (user_playlist_id)
   references user_playlist (id);