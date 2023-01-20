package com.example.post.repository;

import com.example.post.entity.PostVoteEntity;
import com.example.post.entity.PostVoteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostVoteJpaRepository extends JpaRepository<PostVoteEntity, PostVoteId> {

}
