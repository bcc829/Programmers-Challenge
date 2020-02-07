package com.example.demo.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserPlaylistSong is a Querydsl query type for UserPlaylistSong
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserPlaylistSong extends EntityPathBase<UserPlaylistSong> {

    private static final long serialVersionUID = -1141739763L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserPlaylistSong userPlaylistSong = new QUserPlaylistSong("userPlaylistSong");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> regDate = createDateTime("regDate", java.util.Date.class);

    public final QSong song;

    public final DateTimePath<java.util.Date> updateDate = createDateTime("updateDate", java.util.Date.class);

    public final QUserPlaylist userPlaylist;

    public QUserPlaylistSong(String variable) {
        this(UserPlaylistSong.class, forVariable(variable), INITS);
    }

    public QUserPlaylistSong(Path<? extends UserPlaylistSong> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserPlaylistSong(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserPlaylistSong(PathMetadata metadata, PathInits inits) {
        this(UserPlaylistSong.class, metadata, inits);
    }

    public QUserPlaylistSong(Class<? extends UserPlaylistSong> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.song = inits.isInitialized("song") ? new QSong(forProperty("song"), inits.get("song")) : null;
        this.userPlaylist = inits.isInitialized("userPlaylist") ? new QUserPlaylist(forProperty("userPlaylist")) : null;
    }

}

