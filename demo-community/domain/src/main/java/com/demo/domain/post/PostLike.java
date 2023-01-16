package com.demo.domain.post;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class PostLike implements Serializable {
    @Id
    private Long postId;

    @Id
    private Long memberUid;

    @CreatedDate
    private LocalDateTime createdAt;
}
