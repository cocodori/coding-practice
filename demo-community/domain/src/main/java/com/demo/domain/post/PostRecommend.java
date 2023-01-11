package com.demo.domain.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PostRecommend {
    @Id
    private Long postId;

    @Column(name = "recommend_score")
    private int score;
}
