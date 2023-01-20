package com.example.post.port;

import com.example.post.usecase.command.PostCreateCommand;

import java.util.Set;

public interface PostCreatePort {

    Long savePost(PostCreateCommand command);

    void saveAllPostTag(Long postId, Set<Long> tagIds);

    void savePostVote(Long postId, Long voteId);

    void saveAllImages(Set<String> images);
}
