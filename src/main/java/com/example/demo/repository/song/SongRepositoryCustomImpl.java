package com.example.demo.repository.song;

import com.example.demo.contants.Constants;
import com.example.demo.domain.entity.QAlbumLocale;
import com.example.demo.domain.entity.QSong;
import com.example.demo.domain.entity.Song;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class SongRepositoryCustomImpl extends QuerydslRepositorySupport implements SongRepositoryCustom {

    public SongRepositoryCustomImpl() {
        super(Song.class);
    }

    @Override
    public List<Song> getSongsByLikeSongTitleAndLocalesIn(String songTitle, String locale) {
        QSong song = QSong.song;
        QAlbumLocale albumLocale = QAlbumLocale.albumLocale;

        return from(song)
                .distinct()
                .innerJoin(albumLocale)
                .on(albumLocale.album.eq(song.album))
                .where(song.title.contains(songTitle)
                        .and(albumLocale.locale.eq(locale)
                        .or(albumLocale.locale.eq(Constants.ALL))))
                .fetch();
    }
}
