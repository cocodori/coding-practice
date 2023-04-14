package com.example.txrollbacktest.post.adapter;

import com.example.txrollbacktest.post.domain.Tag;
import com.example.txrollbacktest.post.port.PersistTagPort;
import com.example.txrollbacktest.repository.entity.TagEntity;
import com.example.txrollbacktest.repository.entity.TagJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
class PersistTagAdapter implements PersistTagPort {

    private final TagJpaRepository tagJpaRepository;

    PersistTagAdapter(TagJpaRepository tagJpaRepository) {
        this.tagJpaRepository = tagJpaRepository;
    }

    @Transactional
    @Override
    public Tag save(Tag tag) {
        var entity = tagJpaRepository.save(TagEntity.of(tag));
        return new Tag(entity.getPostId(), entity.getName());
    }
}
