package com.example.post.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long postId;

    String path;

    public PostImageEntity(Long postId, String path) {
        this.postId = postId;
        this.path = path;
    }

    public static PostImageEntity of(Long postId, String path) {
        return new PostImageEntity(postId, path);
    }
}
