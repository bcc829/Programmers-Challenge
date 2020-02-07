package com.example.demo;

import com.example.demo.domain.entity.*;
import com.example.demo.repository.album.AlbumRepository;
import com.example.demo.repository.userPlaylist.UserPlayListRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.PreDestroy;

@Component
@ActiveProfiles("local")
public class AppRunner implements ApplicationRunner {

    private AlbumRepository albumRepository;
    private UserPlayListRepository userPlayListRepository;

    public AppRunner(AlbumRepository albumRepository, UserPlayListRepository userPlayListRepository) {
        this.albumRepository = albumRepository;
        this.userPlayListRepository = userPlayListRepository;
    }

    @Override
    public void run(ApplicationArguments args) {

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

}
