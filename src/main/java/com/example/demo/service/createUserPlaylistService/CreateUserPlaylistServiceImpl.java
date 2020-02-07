package com.example.demo.service.createUserPlaylistService;

import com.example.demo.domain.dto.UserPlaylistDto;
import com.example.demo.domain.entity.UserPlaylist;
import com.example.demo.repository.userPlaylist.UserPlayListRepository;
import com.example.demo.util.ModelMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateUserPlaylistServiceImpl implements CreateUserPlaylistService {

    private UserPlayListRepository userPlayListRepository;
    private ModelMapperUtil modelMapperUtil;

    private Logger logger = LoggerFactory.getLogger(CreateUserPlaylistServiceImpl.class);

    public CreateUserPlaylistServiceImpl(UserPlayListRepository userPlayListRepository,
                                         ModelMapperUtil modelMapperUtil) {
        this.userPlayListRepository = userPlayListRepository;
        this.modelMapperUtil = modelMapperUtil;
    }

    @Override
    public UserPlaylistDto createUserPlaylist(UserPlaylistDto userPlaylistDto) {

        UserPlaylist userPlaylist = modelMapperUtil.convertToDomain(userPlaylistDto, UserPlaylist.class);

        userPlaylist = userPlayListRepository.save(userPlaylist);

        UserPlaylistDto result = modelMapperUtil.convertToDomain(userPlaylist, UserPlaylistDto.class);

        logger.info("createUserPlaylist result - {}", result.toString());

        return result;
    }
}
