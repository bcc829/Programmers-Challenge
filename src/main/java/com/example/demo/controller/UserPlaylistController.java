package com.example.demo.controller;

import com.example.demo.domain.dto.AlbumDto;
import com.example.demo.domain.dto.SongDto;
import com.example.demo.domain.dto.UserPlaylistDto;
import com.example.demo.service.createUserPlaylistService.CreateUserPlaylistService;
import com.example.demo.service.deleteUserPlaylistService.DeleteUserPlaylistService;
import com.example.demo.service.findUserplaylistService.FindUserPlaylistService;
import com.example.demo.service.userPlaylistAddSongService.UserPlaylistAddSongService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/user-playlist")
    public UserPlaylistDto createUserPlaylist(@RequestBody UserPlaylistDto userPlaylistDto,
                                              HttpServletResponse response) {
        UserPlaylistDto result = createUserPlaylistService.createUserPlaylist(userPlaylistDto);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return result;
    }

    @DeleteMapping("/user-playlist/{userPlaylistId}")
    public void deleteUserPlaylist(@PathVariable long userPlaylistId) {
        deleteUserPlaylistService.deleteUserPlaylistById(userPlaylistId);
    }

    @GetMapping("/user/{userId}/user-playlists")
    public List<UserPlaylistDto> findAllUserPlaylistsByUserId(@PathVariable long userId) {
        return findUserPlaylistService.findUserPlaylistAllByUserId(userId);
    }

    @PostMapping("/user-playlist/{userPlaylistId}/user-playlist-song/song")
    public UserPlaylistDto userPlaylistAddSongWithSongDto(@PathVariable long userPlaylistId,
                                                          @RequestBody SongDto songDto,
                                                          HttpServletResponse response) {
        UserPlaylistDto result = userPlaylistAddSongService.userPlaylistAddSongWithSong(userPlaylistId, songDto);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return result;
    }

    @PostMapping("/user-playlist/{userPlaylistId}/user-playlist-song/album")
    public UserPlaylistDto userPlaylistAddSongWithAlbumDto(@PathVariable long userPlaylistId,
                                                          @RequestBody AlbumDto albumDto,
                                                           HttpServletResponse response) {
        UserPlaylistDto result = userPlaylistAddSongService.userPlaylistAddSongWithAlbum(userPlaylistId, albumDto);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return result;
    }

}
