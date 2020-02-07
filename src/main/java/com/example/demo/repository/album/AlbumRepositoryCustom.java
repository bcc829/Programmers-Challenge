package com.example.demo.repository.album;

import com.example.demo.domain.entity.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlbumRepositoryCustom {
    List<Album> getAlbumsByLikeAlbumTitleAndLocalesIn(String albumTitle, String locale);
    Page<Album> getPagingAlbumLocalesIn(Pageable pageable, String locale);
}
