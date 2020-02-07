package com.example.demo.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    long userId;
    @Column(nullable = false)
    String title;
    @OneToMany(mappedBy = "userPlaylist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<UserPlaylistSong> userPlaylistSongs =  new ArrayList<>();
    @CreatedDate
    Date regDate;
    @LastModifiedDate
    Date updateDate;

    public void addUserPlaylistSong(UserPlaylistSong userPlaylistSong) {
        userPlaylistSong.userPlaylist = this;

        userPlaylistSongs.add(userPlaylistSong);
    }

}
