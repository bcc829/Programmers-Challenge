package com.example.demo.service.userPlaylistAddSongService;

import com.example.demo.domain.dto.AlbumDto;
import com.example.demo.domain.dto.SongDto;
import com.example.demo.domain.dto.UserPlaylistDto;
import com.example.demo.domain.entity.*;
import com.example.demo.repository.album.AlbumRepository;
import com.example.demo.repository.song.SongRepository;
import com.example.demo.repository.userPlaylist.UserPlayListRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class UserPlaylistAddSongServiceTest {


    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private UserPlayListRepository userPlayListRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private UserPlaylistAddSongService userPlaylistAddSongService;

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
    public void userPlaylistAddSongTest() {
        UserPlaylist userPlaylist = userPlayListRepository.findAll().get(0);
        Song song = songRepository.findAll().get(0);

        SongDto songDto = new SongDto();

        songDto.setId(song.getId());
        songDto.setLength(song.getLength());
        songDto.setTitle(song.getTitle());
        songDto.setTrack(song.getTrack());

        UserPlaylistDto userPlaylistDto = userPlaylistAddSongService
                .userPlaylistAddSongWithSong(userPlaylist.getId(), songDto);

        assertTrue(userPlaylistDto.getUserPlaylistSongs().stream()
                .anyMatch(it -> it.getSong().getId() == song.getId()));
    }

    @Test
    public void userPlaylistAddAlbumTest() {
        UserPlaylist userPlaylist = userPlayListRepository.findAll().get(0);
        Album album = albumRepository.findAll().get(0);

        Song song = songRepository.findTopByAlbum_Id(album.getId());

        AlbumDto albumDto = new AlbumDto();
        albumDto.setId(album.getId());

        UserPlaylistDto userPlaylistDto = userPlaylistAddSongService
                .userPlaylistAddSongWithAlbum(userPlaylist.getId(), albumDto);

        assertTrue(userPlaylistDto.getUserPlaylistSongs().stream()
                .anyMatch(it -> it.getSong().getId() == song.getId()));
    }

    @After
    public void afterAlbumRepositoryTest() {
        this.userPlayListRepository.deleteAll();
        this.albumRepository.deleteAll();
    }
}
