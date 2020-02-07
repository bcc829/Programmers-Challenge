package com.example.demo.service.getAlbumService;

import com.example.demo.domain.dto.PaginatedAlbumsDto;
import com.example.demo.domain.entity.Album;
import com.example.demo.domain.entity.AlbumLocale;
import com.example.demo.domain.entity.Song;
import com.example.demo.repository.album.AlbumRepository;
import com.example.demo.service.getAlbumsService.GetAlbumsServiceImpl;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class GetAlbumsServiceTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private GetAlbumsServiceImpl getAlbumsService;

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
        Pageable pageable = PageRequest.of(0, 1);
        PaginatedAlbumsDto albumsWithPaging = getAlbumsService.getAlbumsWithPaging(pageable, "kr", "http://localhost:8080/albums");

        assertEquals(1, albumsWithPaging.getAlbums().size());
    }

    @After
    public void afterAlbumRepositoryTest() {
        this.albumRepository.deleteAll();
    }
}
