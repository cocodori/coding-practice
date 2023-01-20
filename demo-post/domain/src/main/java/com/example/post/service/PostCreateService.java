package com.example.post.service;

import com.example.post.domain.Tag;
import com.example.post.port.PostCreatePort;
import com.example.post.port.PostTagViewPort;
import com.example.post.port.TagCreatePort;
import com.example.post.port.VoteCreatePort;
import com.example.post.usecase.PostCreateUseCase;
import com.example.post.usecase.PostViewUseCase;
import com.example.post.usecase.command.PostCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase, PostViewUseCase {

    private final PostCreatePort postCreatePort;
    private final PostTagViewPort postTagViewPort;
    private final TagCreatePort tagCreatePort;
    private final VoteCreatePort voteCreatePort;

    @Override
    @Transactional
    public Long create(PostCreateCommand command) {
        // 게시물 등록
        Long postId = postCreatePort.savePost(command);

        // 이미지 등록
        postCreatePort.saveAllImages(command.images);

        // 태그 등록
        saveAllTag(command, postId);

        // 투표 등록
        saveVote(command, postId);

        // TODO: 게시물 등록 이벤트 발행

        return postId;
    }

    private void saveVote(PostCreateCommand command, Long postId) {
        // vote, vote_item 등록
        Long voteId = voteCreatePort.createVote(command.voteCommand);

        // post_vote 등록
        postCreatePort.savePostVote(postId, voteId);
    }

    private void saveAllTag(PostCreateCommand command, Long postId) {
        // 등록된 해시태그 조회 결과에서 태그 이름만 추출
        Set<Tag> hashtags = postTagViewPort.findAllHashtagByNames(command.hashtags);
        Set<String> hashtagNames = getHashtagNames(hashtags);

        // DB에 없는 태그만 등록
        Set<Long> newHashtagIds = saveAllNewHashtag(command, hashtagNames);

        // 포스트-태그 연결 테이블 등록
        // 기존 DB에 있던 태그 ID + 새로 등록한 태그 ID
        saveAllPostTag(postId, hashtags, newHashtagIds);
    }

    private void saveAllPostTag(Long postId, Set<Tag> hashtags, Set<Long> newHashtagIds) {
        newHashtagIds.addAll(hashtags.stream()
                .map(Tag::getId)
                .collect(Collectors.toSet()));

        postCreatePort.saveAllPostTag(postId, newHashtagIds);
    }

    private Set<Long> saveAllNewHashtag(PostCreateCommand command, Set<String> hashtagNames) {
        return command.hashtags.stream()
                .filter(name -> !hashtagNames.contains(name))
                .map(tagCreatePort::createHashtag)
                .collect(Collectors.toSet());
    }

    private Set<String> getHashtagNames(Set<Tag> hashtags) {
        return hashtags
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }
}
