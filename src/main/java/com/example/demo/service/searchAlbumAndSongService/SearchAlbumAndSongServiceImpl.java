package com.example.demo.service.searchAlbumAndSongService;

import com.example.demo.domain.dto.AlbumDto;
import com.example.demo.domain.dto.SearchAlbumsAndSongsResultDto;
import com.example.demo.domain.dto.SongDto;
import com.example.demo.domain.entity.Album;
import com.example.demo.domain.entity.Song;
import com.example.demo.repository.album.AlbumRepository;
import com.example.demo.repository.song.SongRepository;
import com.example.demo.util.ModelMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchAlbumAndSongServiceImpl implements SearchAlbumAnsSongService {

    private SongRepository songRepository;

    private AlbumRepository albumRepository;

    private ModelMapperUtil modelMapperUtil;

    private Logger logger = LoggerFactory.getLogger(SearchAlbumAndSongServiceImpl.class);

    public SearchAlbumAndSongServiceImpl(SongRepository songRepository,
                                         AlbumRepository albumRepository,
                                         ModelMapperUtil modelMapperUtil) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.modelMapperUtil = modelMapperUtil;
    }

    @Transactional
    public SearchAlbumsAndSongsResultDto getSearchResultAlbumAndSongByTitleAndLocale(String title, String locale) {

        logger.info("getSearchResultAlbumAndSongByTitleAndLocale parameter - title{}, locale: {}", title, locale);

        List<Album> albumsByLikeAlbumTitleAndLocalesIn = albumRepository.getAlbumsByLikeAlbumTitleAndLocalesIn(title, locale);

        List<Song> songsByLikeSongTitleAndLocalesIn = songRepository.getSongsByLikeSongTitleAndLocalesIn(title, locale);

        List<AlbumDto> albumDtos = albumsByLikeAlbumTitleAndLocalesIn
                .stream()
                .map(it -> modelMapperUtil.convertToDomain(it, AlbumDto.class))
                .collect(Collectors.toList());

        List<SongDto> songDtos = songsByLikeSongTitleAndLocalesIn
                .stream()
                .map(it -> modelMapperUtil.convertToDomain(it, SongDto.class))
                .collect(Collectors.toList());


        SearchAlbumsAndSongsResultDto result = SearchAlbumsAndSongsResultDto.builder()
                .albums(albumDtos)
                .songs(songDtos)
                .build();

        logger.info("getSearchResultAlbumAndSongByTitleAndLocale result : {}", result.toString());

        return result;
    }
}
