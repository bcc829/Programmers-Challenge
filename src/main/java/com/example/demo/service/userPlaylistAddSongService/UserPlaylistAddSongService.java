package com.example.demo.service.userPlaylistAddSongService;

import com.example.demo.domain.dto.AlbumDto;
import com.example.demo.domain.dto.SongDto;
import com.example.demo.domain.dto.UserPlaylistDto;

public interface UserPlaylistAddSongService {
    UserPlaylistDto userPlaylistAddSongWithSong(long playlistId, SongDto songDto);
    UserPlaylistDto userPlaylistAddSongWithAlbum(long playlistId, AlbumDto albumDto);
}
