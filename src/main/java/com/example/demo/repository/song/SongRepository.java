package com.example.demo.repository.song;

import com.example.demo.domain.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>, SongRepositoryCustom {
    Song findTopByAlbum_Id(long albumId);
}
