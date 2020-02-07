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
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "album")
    List<AlbumLocale> albumLocales = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "album")
    List<Song> songs;
    @CreatedDate
    Date regDate;
    @LastModifiedDate
    Date updateDate;

    public void addAlbumLocale(AlbumLocale albumLocale) {
        albumLocale.album = this;

        albumLocales.add(albumLocale);
    }

    public void addSongs(Song song) {
        song.album = this;

        if(songs == null)
            songs = new ArrayList<>();

        songs.add(song);
    }


}
