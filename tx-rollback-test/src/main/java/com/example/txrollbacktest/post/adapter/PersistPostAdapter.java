package com.example.txrollbacktest.post.adapter;

import com.example.txrollbacktest.post.domain.Post;
import com.example.txrollbacktest.post.port.PersistPostPort;
import com.example.txrollbacktest.repository.entity.PostEntity;
import com.example.txrollbacktest.repository.entity.PostJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
class PersistPostAdapter implements PersistPostPort {

    private final PostJpaRepository postJpaRepository;

    PersistPostAdapter(PostJpaRepository postJpaRepository) {
        this.postJpaRepository = postJpaRepository;
    }


    @Transactional
    @Override
    public Post save(Post post) {
        var entity = postJpaRepository.save(PostEntity.of(post));
        return new Post(entity.getId(), entity.getTitle(), entity.getContent());
    }
}
