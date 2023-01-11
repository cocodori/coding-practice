package com.demo.domain.comment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommentMetadata {

    @Id
    private Long commentId;

    private int likeCount;

    private int hateCount;

    private int claimCount;
}
