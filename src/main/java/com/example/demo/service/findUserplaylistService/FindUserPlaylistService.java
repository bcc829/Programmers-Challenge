package com.example.demo.service.findUserplaylistService;

import com.example.demo.domain.dto.UserPlaylistDto;

import java.util.List;

public interface FindUserPlaylistService {
    List<UserPlaylistDto> findUserPlaylistAllByUserId(long userId);
}
