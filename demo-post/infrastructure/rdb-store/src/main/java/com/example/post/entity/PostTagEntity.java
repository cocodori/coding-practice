package com.example.post.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post_tag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostTagEntity {
    @EmbeddedId
    private PostTagId postTagId;

    public PostTagEntity(Long postId, Long tagId) {
        this.postTagId = PostTagId.of(postId, tagId);
    }


    public static PostTagEntity of(Long postId, Long tagId) {
        return new PostTagEntity(postId, tagId);
    }
}
