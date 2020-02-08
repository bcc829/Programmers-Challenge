package com.example.demo.service.userPlaylistAddSongService;

import com.example.demo.domain.dto.AlbumDto;
import com.example.demo.domain.dto.SongDto;
import com.example.demo.domain.dto.UserPlaylistDto;
import com.example.demo.domain.entity.Album;
import com.example.demo.domain.entity.Song;
import com.example.demo.domain.entity.UserPlaylist;
import com.example.demo.domain.entity.UserPlaylistSong;
import com.example.demo.repository.album.AlbumRepository;
import com.example.demo.repository.song.SongRepository;
import com.example.demo.repository.userPlaylist.UserPlayListRepository;
import com.example.demo.repository.userPlaylistSong.UserPlayListSongRepository;
import com.example.demo.service.searchAlbumAndSongService.SearchAlbumAndSongServiceImpl;
import com.example.demo.util.ModelMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserPlaylistAddSongServiceImpl implements UserPlaylistAddSongService{

    private UserPlayListRepository userPlayListRepository;

    private SongRepository songRepository;

    private AlbumRepository albumRepository;

    private UserPlayListSongRepository userPlayListSongRepository;

    private ModelMapperUtil modelMapperUtil;

    private Logger logger = LoggerFactory.getLogger(SearchAlbumAndSongServiceImpl.class);

    public UserPlaylistAddSongServiceImpl(UserPlayListRepository userPlayListRepository,
                                          SongRepository songRepository,
                                          AlbumRepository albumRepository,
                                          UserPlayListSongRepository userPlayListSongRepository,
                                          ModelMapperUtil modelMapperUtil) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.userPlayListRepository = userPlayListRepository;
        this.userPlayListSongRepository = userPlayListSongRepository;
        this.modelMapperUtil = modelMapperUtil;
    }

    @Override
    @Transactional
    public UserPlaylistDto userPlaylistAddSongWithSong(long playlistId, SongDto songDto) throws NoSuchElementException {

        Optional<UserPlaylist> optionalUserPlaylist = userPlayListRepository.findById(playlistId);
        Optional<Song> optionalSong = songRepository.findById(songDto.getId());

        UserPlaylist userPlaylist = optionalUserPlaylist.get();
        Song song = optionalSong.get();

        UserPlaylistSong userPlaylistSong = new UserPlaylistSong();
        userPlaylistSong.setSong(song);
        userPlaylistSong.setUserPlaylist(userPlaylist);

        userPlayListSongRepository.save(userPlaylistSong);

        UserPlaylistDto result = modelMapperUtil.convertToDomain(userPlaylist, UserPlaylistDto.class);

        logger.info("userPlaylistAddSongWithSong result - {}", result);

        return result;
    }

    @Override
    @Transactional
    public UserPlaylistDto userPlaylistAddSongWithAlbum(long playlistId, AlbumDto albumDto) throws NoSuchElementException {
        Optional<UserPlaylist> optionalUserPlaylist = userPlayListRepository.findById(playlistId);
        Optional<Album> optionalAlbum = albumRepository.findById(albumDto.getId());

        UserPlaylist userPlaylist = optionalUserPlaylist.get();
        Album album = optionalAlbum.get();

        for(Song song: album.getSongs()) {
            UserPlaylistSong userPlaylistSong = new UserPlaylistSong();
            userPlaylistSong.setSong(song);
            userPlaylistSong.setUserPlaylist(userPlaylist);

            userPlayListSongRepository.save(userPlaylistSong);
        }

        UserPlaylistDto result = modelMapperUtil.convertToDomain(userPlaylist, UserPlaylistDto.class);

        logger.info("userPlaylistAddSongWithAlbum result - {}", result);

        return result;
    }
}
