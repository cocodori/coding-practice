package com.demo.domain.post;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PostVote {
    @Id
    private Long postId;

    @Id
    private Long voteId;
}
