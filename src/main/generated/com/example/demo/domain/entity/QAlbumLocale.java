package com.example.demo.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlbumLocale is a Querydsl query type for AlbumLocale
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlbumLocale extends EntityPathBase<AlbumLocale> {

    private static final long serialVersionUID = 458587950L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlbumLocale albumLocale = new QAlbumLocale("albumLocale");

    public final QAlbum album;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final DateTimePath<java.util.Date> regDate = createDateTime("regDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> updateDate = createDateTime("updateDate", java.util.Date.class);

    public QAlbumLocale(String variable) {
        this(AlbumLocale.class, forVariable(variable), INITS);
    }

    public QAlbumLocale(Path<? extends AlbumLocale> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlbumLocale(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlbumLocale(PathMetadata metadata, PathInits inits) {
        this(AlbumLocale.class, metadata, inits);
    }

    public QAlbumLocale(Class<? extends AlbumLocale> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.album = inits.isInitialized("album") ? new QAlbum(forProperty("album")) : null;
    }

}

