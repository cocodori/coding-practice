package com.example.post.adapter.in.dto;

import com.example.post.usecase.command.PostCreateCommand;

import java.util.Set;

public record PostCreateRequest(
        String title,
        String content,

        String categoryTag,

        Set<String> hashtags,

        String voteTitle,

        Set<String> voteItem,

        Set<String> images
) {
    public PostCreateCommand toCommand() {
        return new PostCreateCommand(title, content, categoryTag, hashtags, voteTitle, voteItem, images);
    }
}
