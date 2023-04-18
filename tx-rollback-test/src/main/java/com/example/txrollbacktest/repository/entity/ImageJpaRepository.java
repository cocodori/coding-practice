package com.example.txrollbacktest.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ImageJpaRepository extends JpaRepository<ImageEntity, Long> {

    List<ImageEntity> findAllByPostId(Long actual);
}
