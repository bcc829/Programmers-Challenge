package com.example.demo.repository.userPlaylist;

import com.example.demo.domain.entity.UserPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPlayListRepository extends JpaRepository<UserPlaylist, Long> {
    List<UserPlaylist> getAllByUserId(long userId);
}
