package com.demo.domain.comment;

import com.demo.domain.code.CommentLikeType;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class CommentLike implements Serializable {
    @Id
    private Long commentId;

    @Id
    private Long memberUid;

    @Enumerated(EnumType.STRING)
    private CommentLikeType type;

    @CreatedDate
    private LocalDateTime createdAt;

}
