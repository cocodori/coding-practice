package com.example.post.repository;

import com.example.post.entity.PostTagEntity;
import com.example.post.domain.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagJpaRepository extends JpaRepository<PostTagEntity, PostTag> {
}
