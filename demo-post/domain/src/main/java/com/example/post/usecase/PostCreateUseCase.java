package com.example.post.usecase;

import com.example.post.usecase.command.PostCreateCommand;

public interface PostCreateUseCase {
    Long create(PostCreateCommand postCreateCommand);

}
