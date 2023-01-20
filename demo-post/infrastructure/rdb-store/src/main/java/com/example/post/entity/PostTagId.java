package com.example.post.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostTagId implements Serializable {
    private Long postId;

    private Long tagId;

    PostTagId(Long postId, Long tagId) {
        this.postId = postId;
        this.tagId = tagId;
    }

    static PostTagId of(Long postId, Long tagId) {
        return new PostTagId(postId, tagId);
    }
}
