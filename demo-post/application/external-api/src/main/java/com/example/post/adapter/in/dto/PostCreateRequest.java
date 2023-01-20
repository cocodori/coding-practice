package com.example.post.adapter.in.dto;

import com.example.post.usecase.command.PostCreateCommand;

public record PostCreateRequest(
        String title,
        String content
) {

    public PostCreateCommand toCommand() {
        return new PostCreateCommand(title, content);
    }
}
