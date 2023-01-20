package com.example.repository;

import com.example.entity.PostEntity;
import com.example.post.port.PostCreatePort;
import com.example.post.usecase.command.PostCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RequiredArgsConstructor
public class PostRepository implements PostCreatePort {
    private final PostJpaRepository postJpaRepository;

    @Override
    public Long savePost(PostCreateCommand command) {
        PostEntity post = PostEntity.withoutId(command);
        return postJpaRepository.save(post).id();
    }

    @Override
    public void saveAllPostTag(Long postId, Set<Long> tagIds) {

    }

    @Override
    public void savePostVote(Long postId, Long voteId) {

    }

    @Override
    public void saveAllImages(Set<String> images) {

    }
}
