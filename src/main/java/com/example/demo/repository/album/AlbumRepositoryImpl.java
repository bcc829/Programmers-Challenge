package com.example.demo.repository.album;

import com.example.demo.contants.Constants;
import com.example.demo.domain.entity.Album;
import com.example.demo.domain.entity.QAlbum;
import com.example.demo.domain.entity.QAlbumLocale;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class AlbumRepositoryImpl extends QuerydslRepositorySupport implements AlbumRepositoryCustom {

    public AlbumRepositoryImpl() {
        super(Album.class);
    }

    @Override
    public List<Album> getAlbumsByLikeAlbumTitleAndLocalesIn(String albumTitle, String locale) {
        QAlbum album = QAlbum.album;
        QAlbumLocale albumLocale = QAlbumLocale.albumLocale;

        return
                from(album)
                        .distinct()
                        .innerJoin(albumLocale).on(album.eq(albumLocale.album))
                        .where(album.title.contains(albumTitle)
                                .and(albumLocale.locale.eq(locale)
                                        .or(albumLocale.locale.eq(Constants.ALL))))
                        .fetch();
    }

    @Override
    public Page<Album> getPagingAlbumLocalesIn(Pageable pageable, String locale) {
        QAlbum album = QAlbum.album;
        QAlbumLocale albumLocale = QAlbumLocale.albumLocale;

        JPQLQuery albumsQuery = from(album)
                .distinct()
                .innerJoin(albumLocale).on(album.eq(albumLocale.album))
                .where(albumLocale.locale.eq(locale)
                        .or(albumLocale.locale.eq(Constants.ALL)));


        return new PageImpl<>(getQuerydsl().applyPagination(pageable, albumsQuery).fetch(), pageable, albumsQuery.fetchCount());
    }

}
