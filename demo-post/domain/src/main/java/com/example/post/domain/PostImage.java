package com.example.post.domain;


public record PostImage(
        Long id,
        Long postId,
        String path
) {
}
