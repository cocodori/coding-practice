package com.example.post.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostVoteId implements Serializable {
    private Long postId;
    private Long voteId;

    public PostVoteId(Long postId, Long voteId) {
        this.postId = postId;
        this.voteId = voteId;
    }

    public static PostVoteId of(Long postId, Long voteId) {
        return new PostVoteId(postId, voteId);
    }
}
