package com.example.demo.service.deleteUserPlaylistService;

import com.example.demo.domain.entity.UserPlaylist;
import com.example.demo.repository.userPlaylist.UserPlayListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserPlaylistServiceImpl implements DeleteUserPlaylistService {

    private UserPlayListRepository userPlayListRepository;

    private Logger logger = LoggerFactory.getLogger(DeleteUserPlaylistServiceImpl.class);

    public DeleteUserPlaylistServiceImpl(UserPlayListRepository userPlayListRepository) {
        this.userPlayListRepository = userPlayListRepository;
    }

    @Override
    public boolean deleteUserPlaylistById(long playlistId) {

        Optional<UserPlaylist> optionalUserPlaylist = userPlayListRepository.findById(playlistId);

        if(!optionalUserPlaylist.isPresent()) {
            logger.info("deleteUserPlaylistById - no element by {} return true", playlistId);
            return true;
        }

        UserPlaylist userPlaylist = optionalUserPlaylist.get();

        userPlayListRepository.delete(userPlaylist);

        logger.info("deleteUserPlaylistById result - true");

        return true;
    }
}
