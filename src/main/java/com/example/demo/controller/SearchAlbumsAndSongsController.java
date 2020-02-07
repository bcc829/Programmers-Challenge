package com.example.demo.controller;

import com.example.demo.domain.dto.SearchAlbumsAndSongsResultDto;
import com.example.demo.service.searchAlbumAndSongService.SearchAlbumAndSongServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchAlbumsAndSongsController {

    private SearchAlbumAndSongServiceImpl searchAlbumAndSongService;

    public SearchAlbumsAndSongsController(SearchAlbumAndSongServiceImpl searchAlbumAndSongService) {
        this.searchAlbumAndSongService = searchAlbumAndSongService;
    }

    @GetMapping
    public SearchAlbumsAndSongsResultDto getSearchResultAlbumsAndSongsByTitleAndLocale(@RequestParam String title,
                                                                                   @RequestParam String locale) {
        return searchAlbumAndSongService.getSearchResultAlbumAndSongByTitleAndLocale(title, locale);
    }
}
