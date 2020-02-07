package com.example.demo.service.searchAlbumAndSongService;

import com.example.demo.domain.dto.SearchAlbumsAndSongsResultDto;
import com.example.demo.domain.entity.Album;
import com.example.demo.domain.entity.AlbumLocale;
import com.example.demo.domain.entity.Song;
import com.example.demo.repository.album.AlbumRepository;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class SearchAlbumAndSongServiceTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SearchAlbumAndSongServiceImpl searchAlbumAndSongService;

    @Before
    public void beforeAlbumRepositoryTest() {

        albumRepository.deleteAll();

        Album testData1 = new Album();
        testData1.setTitle("my album1");

        Album testData2 = new Album();
        testData2.setTitle("my album2");

        Song testSong1 = new Song();

        testSong1.setLength(300);
        testSong1.setTrack(1);
        testSong1.setTitle("my album1 - 1");


        Song testSong2 = new Song();
        testSong2.setLength(300);
        testSong2.setTrack(1);
        testSong2.setTitle("my album1 - 2");

        Song testSong3 = new Song();

        testSong3.setLength(300);
        testSong3.setTrack(2);
        testSong3.setTitle("my album2 - 1");

        AlbumLocale albumLocale1 = new AlbumLocale();
        albumLocale1.setLocale("kr");

        AlbumLocale albumLocale2 = new AlbumLocale();
        albumLocale2.setLocale("en");

        AlbumLocale albumLocale3 = new AlbumLocale();
        albumLocale3.setLocale("all");

        testData1.addAlbumLocale(albumLocale3);
        testData1.addSongs(testSong1);
        testData1.addSongs(testSong2);

        testData2.addAlbumLocale(albumLocale1);
        testData2.addAlbumLocale(albumLocale2);
        testData2.addSongs(testSong3);

        this.albumRepository.save(testData1);
        this.albumRepository.save(testData2);
    }

    @Test
    public void getSearchResultAlbumAndSongByTitleAndLocaleTest() {
        SearchAlbumsAndSongsResultDto searchResultAlbumAndSongByTitleAndLocale = searchAlbumAndSongService.getSearchResultAlbumAndSongByTitleAndLocale("my album", "jp");
        assertEquals(1, searchResultAlbumAndSongByTitleAndLocale.getAlbums().size());
        assertEquals(2, searchResultAlbumAndSongByTitleAndLocale.getSongs().size());
    }

    @After
    public void afterAlbumRepositoryTest() {
        this.albumRepository.deleteAll();
    }
}
