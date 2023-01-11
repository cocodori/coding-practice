package com.demo.domain.comment;

import com.demo.domain.code.CommentLikeType;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class CommentLike {
    @Id
    private Long commentId;

    @Id
    private String memberUid;

    @Enumerated(EnumType.STRING)
    private CommentLikeType type;

    @CreatedDate
    private LocalDateTime createdAt;
}
