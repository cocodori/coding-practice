package com.demo.domain.comment;

import com.demo.domain.code.ClaimStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class CommentClaim {

    @Id
    private Long commentId;

    @Id
    private String memberUid;

    @Column(columnDefinition = "text")
    private String content;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
