package com.example.demo.repository.userPlaylist;

import com.example.demo.domain.entity.*;
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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class UserPlaylistRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private UserPlayListRepository userPlayListRepository;

    @Before
    public void beforeAlbumRepositoryTest() {
        this.userPlayListRepository.deleteAll();
        this.albumRepository.deleteAll();

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
        testSong3.setTrack(1);
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

        UserPlaylist playListData1 = new UserPlaylist();
        playListData1.setUserId(1L);
        playListData1.setTitle("user 1's playlist1");

        UserPlaylist playListData2 = new UserPlaylist();
        playListData2.setUserId(1L);
        playListData2.setTitle("user 1's playlist2");

        UserPlaylist playListData3 = new UserPlaylist();
        playListData3.setUserId(2L);
        playListData3.setTitle("user 2's playlist1");

        UserPlaylistSong playlistSongData1 = new UserPlaylistSong();
        playlistSongData1.setSong(testSong1);

        UserPlaylistSong playlistSongData2 = new UserPlaylistSong();
        playlistSongData2.setSong(testSong2);

        UserPlaylistSong playlistSongData3 = new UserPlaylistSong();
        playlistSongData3.setSong(testSong3);

        UserPlaylistSong playlistSongData4 = new UserPlaylistSong();
        playlistSongData4.setSong(testSong2);


        playListData1.addUserPlaylistSong(playlistSongData1);
        playListData1.addUserPlaylistSong(playlistSongData2);

        playListData2.addUserPlaylistSong(playlistSongData3);

        playListData3.addUserPlaylistSong(playlistSongData4);

        albumRepository.save(testData1);
        albumRepository.save(testData2);

        userPlayListRepository.save(playListData1);
        userPlayListRepository.save(playListData2);
        userPlayListRepository.save(playListData3);
    }

    @Test
    public void getUserPlaylistByUserId(){
        List<UserPlaylist> allByUserId = userPlayListRepository.getAllByUserId(1L);
        assertEquals(2, allByUserId.size());
    }

    @After
    public void afterAlbumRepositoryTest() {
        this.albumRepository.deleteAll();
    }

}
