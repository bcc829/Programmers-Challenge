package com.example.demo.service.searchAlbumAndSongService;

import com.example.demo.domain.dto.SearchAlbumsAndSongsResultDto;

public interface SearchAlbumAnsSongService {
    SearchAlbumsAndSongsResultDto getSearchResultAlbumAndSongByTitleAndLocale(String title, String locale);
}
