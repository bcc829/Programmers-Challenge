package com.example.demo.service.findUserplaylistService;

import com.example.demo.domain.dto.UserPlaylistDto;
import com.example.demo.domain.entity.UserPlaylist;
import com.example.demo.repository.userPlaylist.UserPlayListRepository;
import com.example.demo.service.createUserPlaylistService.CreateUserPlaylistServiceImpl;
import com.example.demo.util.ModelMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindUserPlaylistServiceImpl implements FindUserPlaylistService {

    private UserPlayListRepository userPlayListRepository;

    private ModelMapperUtil modelMapperUtil;

    private Logger logger = LoggerFactory.getLogger(CreateUserPlaylistServiceImpl.class);

    public FindUserPlaylistServiceImpl(UserPlayListRepository userPlayListRepository,
                                       ModelMapperUtil modelMapperUtil) {
        this.userPlayListRepository = userPlayListRepository;
        this.modelMapperUtil = modelMapperUtil;
    }

    @Override
    @Transactional
    public List<UserPlaylistDto> findUserPlaylistAllByUserId(long userId) {

        List<UserPlaylist> userPlaylists = userPlayListRepository.getAllByUserId(userId);

        List<UserPlaylistDto> userPlaylistDtos = userPlaylists.stream()
                .map(it -> modelMapperUtil.convertToDomain(it, UserPlaylistDto.class))
                .collect(Collectors.toList());

        logger.info("findUserPlaylistAllByUserId result - {}", userPlaylistDtos.toString());

        return userPlaylistDtos;
    }
}
