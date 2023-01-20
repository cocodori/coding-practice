package com.example.post.repository;

import com.example.post.entity.PostImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostImageJpaRepository extends JpaRepository<PostImageEntity, Long> {
}
