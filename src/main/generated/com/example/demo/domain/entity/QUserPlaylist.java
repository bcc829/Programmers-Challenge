package com.example.demo.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserPlaylist is a Querydsl query type for UserPlaylist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserPlaylist extends EntityPathBase<UserPlaylist> {

    private static final long serialVersionUID = -584601128L;

    public static final QUserPlaylist userPlaylist = new QUserPlaylist("userPlaylist");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> regDate = createDateTime("regDate", java.util.Date.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updateDate = createDateTime("updateDate", java.util.Date.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final ListPath<UserPlaylistSong, QUserPlaylistSong> userPlaylistSongs = this.<UserPlaylistSong, QUserPlaylistSong>createList("userPlaylistSongs", UserPlaylistSong.class, QUserPlaylistSong.class, PathInits.DIRECT2);

    public QUserPlaylist(String variable) {
        super(UserPlaylist.class, forVariable(variable));
    }

    public QUserPlaylist(Path<? extends UserPlaylist> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserPlaylist(PathMetadata metadata) {
        super(UserPlaylist.class, metadata);
    }

}

