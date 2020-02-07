package com.example.demo.controller;

import com.example.demo.domain.dto.AlbumDto;
import com.example.demo.domain.dto.SongDto;
import com.example.demo.domain.dto.UserPlaylistDto;
import com.example.demo.service.createUserPlaylistService.CreateUserPlaylistService;
import com.example.demo.service.deleteUserPlaylistService.DeleteUserPlaylistService;
import com.example.demo.service.findUserplaylistService.FindUserPlaylistService;
import com.example.demo.service.userPlaylistAddSongService.UserPlaylistAddSongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserPlaylistController {

    private CreateUserPlaylistService createUserPlaylistService;
    private UserPlaylistAddSongService userPlaylistAddSongService;
    private FindUserPlaylistService findUserPlaylistService;
    private DeleteUserPlaylistService deleteUserPlaylistService;

    public UserPlaylistController(CreateUserPlaylistService createUserPlaylistService,
                                  UserPlaylistAddSongService userPlaylistAddSongService,
                                  FindUserPlaylistService findUserPlaylistService,
                                  DeleteUserPlaylistService deleteUserPlaylistService) {
        this.createUserPlaylistService = createUserPlaylistService;
        this.userPlaylistAddSongService = userPlaylistAddSongService;
        this.findUserPlaylistService = findUserPlaylistService;
        this.deleteUserPlaylistService = deleteUserPlaylistService;
    }

    @PostMapping("/userPlaylist")
    public UserPlaylistDto createUserPlaylist(@RequestBody UserPlaylistDto userPlaylistDto) {
        return createUserPlaylistService.createUserPlaylist(userPlaylistDto);
    }

    @DeleteMapping("/userPlaylist/{userPlaylistId}")
    public boolean deleteUserPlaylist(@PathVariable long userPlaylistId) {
        return deleteUserPlaylistService.deleteUserPlaylistById(userPlaylistId);
    }

    @GetMapping("/user/{userId}/userPlaylists")
    public List<UserPlaylistDto> findAllUserPlaylistsByUserId(@PathVariable long userId) {
        return findUserPlaylistService.findUserPlaylistAllByUserId(userId);
    }

    @PostMapping("/userPlaylist/{userPlaylistId}/userPlaylistSongs/song")
    public UserPlaylistDto userPlaylistAddSongWithSongDto(@PathVariable long userPlaylistId,
                                                          @RequestBody SongDto songDto) {
        return userPlaylistAddSongService.userPlaylistAddSongWithSong(userPlaylistId, songDto);
    }

    @PostMapping("/userPlaylist/{userPlaylistId}/userPlaylistSongs/album")
    public UserPlaylistDto userPlaylistAddSongWithAlbumDto(@PathVariable long userPlaylistId,
                                                          @RequestBody AlbumDto albumDto) {
        return userPlaylistAddSongService.userPlaylistAddSongWithAlbum(userPlaylistId, albumDto);
    }

}
