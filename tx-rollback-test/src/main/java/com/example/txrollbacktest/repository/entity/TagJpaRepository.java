package com.example.txrollbacktest.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TagJpaRepository extends JpaRepository<TagEntity, Long> {

    List<TagEntity> findAllByPostId(Long actual);
}
