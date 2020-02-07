package com.example.demo.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    int track;
    @Column(nullable = false)
    int length;
    @ManyToOne(fetch = FetchType.EAGER)
    Album album;
    @CreatedDate
    Date regDate;
    @LastModifiedDate
    Date updateDate;
}
