package com.demo.domain.post;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class PostLike {
    @Id
    private Long postId;

    @Id
    private String memberUid;

    @CreatedDate
    private LocalDateTime createdAt;
}
