package com.demo.domain.post;

import com.demo.domain.code.ClaimStatus;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class PostClaim {
    @Id
    private Long postId;

    @Id
    private String memberUid;

    @Column(columnDefinition = "text")
    private String content;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

