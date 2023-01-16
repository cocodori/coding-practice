package com.demo.domain.post;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class PostVote implements Serializable {
    @Id
    private Long postId;

    @Id
    private Long voteId;
}
