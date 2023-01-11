package com.demo.domain.post;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PostMetadata {
    @Id
    private Long postId;

    private int likeCount;

    private int claimCount;
}
