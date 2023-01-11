package com.demo.domain.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class CommentImage {
    @Id
    @Column(name = "comment_image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bucketName;

    private String relativePath;

    private LocalDateTime createdAt;
}
