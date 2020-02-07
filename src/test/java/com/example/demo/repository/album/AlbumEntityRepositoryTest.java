package com.example.demo.repository.album;

import com.example.demo.domain.entity.Album;
import com.example.demo.domain.entity.AlbumLocale;
import com.example.demo.domain.entity.Song;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class AlbumEntityRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Before
    public void beforeAlbumRepositoryTest() {
        this.albumRepository.deleteAll();

        Album testData1 = new Album();
        testData1.setTitle("my album1");

        Album testData2 = new Album();
        testData2.setTitle("my album2");

        Song testSong1 = new Song();

        testSong1.setLength(300);
        testSong1.setTrack(1);
        testSong1.setTitle("my song1 - 1");


        Song testSong2 = new Song();
        testSong2.setLength(300);
        testSong2.setTrack(1);
        testSong2.setTitle("my song1 - 2");

        Song testSong3 = new Song();

        testSong3.setLength(300);
        testSong3.setTrack(1);
        testSong3.setTitle("my song2 - 1");

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
    public void findByAlbumsTitleLikeAndLocalesInLocaleJpTest(){
        List<Album> albumEntities = albumRepository.getAlbumsByLikeAlbumTitleAndLocalesIn("my album", "jp");
        assertEquals(1, albumEntities.size());
    }

    @Test
    public void findByAlbumsTitleLikeAndLocalesInLocaleKRTest(){
        List<Album> albumEntities = albumRepository.getAlbumsByLikeAlbumTitleAndLocalesIn("my album", "kr");
        assertEquals(2, albumEntities.size());
    }

    @Test
    public void getPageAlbums() {
        Pageable pageable = PageRequest.of(1, 10);

        albumRepository.getPagingAlbumLocalesIn(pageable, "kr");

        assertTrue(true);
    }


    @After
    public void afterAlbumRepositoryTest() {
        this.albumRepository.deleteAll();
    }

}
