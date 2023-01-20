package com.example.post.adapter.out;

import com.example.post.entity.PostEntity;
import com.example.post.entity.PostImageEntity;
import com.example.post.entity.PostTagEntity;
import com.example.post.entity.PostVoteEntity;
import com.example.post.port.PostCreatePort;
import com.example.post.usecase.command.PostCreateCommand;
import com.example.post.repository.PostImageJpaRepository;
import com.example.post.repository.PostJpaRepository;
import com.example.post.repository.PostTagJpaRepository;
import com.example.post.repository.PostVoteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RequiredArgsConstructor
public class PostCreatePortAdapter implements PostCreatePort {
    private final PostJpaRepository postJpaRepository;
    private final PostTagJpaRepository postTagJpaRepository;
    private final PostVoteJpaRepository postVoteJpaRepository;
    private final PostImageJpaRepository postImageJpaRepository;

    @Override
    public Long savePost(PostCreateCommand command) {
        PostEntity post = PostEntity.withoutId(command);
        return postJpaRepository.save(post).id();
    }

    @Override
    public void saveAllPostTag(Long postId, Set<Long> tagIds) {
        tagIds.forEach(tagId -> postTagJpaRepository.save(PostTagEntity.of(postId, tagId)));
    }

    @Override
    public void savePostVote(Long postId, Long voteId) {
        postVoteJpaRepository.save(PostVoteEntity.of(postId, voteId));
    }

    @Override
    public void saveAllImages(Long postId, Set<String> images) {
        images.forEach(imgPath -> postImageJpaRepository.save(PostImageEntity.of(postId, imgPath)));
    }
}
