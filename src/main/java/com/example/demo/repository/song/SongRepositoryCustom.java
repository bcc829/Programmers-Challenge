package com.example.demo.repository.song;

import com.example.demo.domain.entity.Song;

import java.util.List;

public interface SongRepositoryCustom {
    List<Song> getSongsByLikeSongTitleAndLocalesIn(String songTitle, String locale);
}
