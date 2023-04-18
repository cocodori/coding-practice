package com.example.txrollbacktest.post.domain;

public record Post(
    Long id,
    String title,
    String content
) {

    public static Post of(String title, String content) {
        return new Post(null, title, content);
    }
}
