package com.example.post.domain;

import com.example.post.domain.code.PostStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {
    Long id;

    String title;

    String content;

    PostStatus status;

    LocalDateTime publishedAt;
}
