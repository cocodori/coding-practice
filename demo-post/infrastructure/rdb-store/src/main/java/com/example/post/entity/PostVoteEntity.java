package com.example.post.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post_vote")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostVoteEntity {
    @EmbeddedId
    private PostVoteId postVoteId;

    public PostVoteEntity(Long postId, Long voteId) {
        this.postVoteId = PostVoteId.of(postId, voteId);
    }


    public static PostVoteEntity of(Long postId, Long voteId) {
        return new PostVoteEntity(postId, voteId);
    }
}
