package com.example.txrollbacktest.post.adapter;

import com.example.txrollbacktest.post.domain.Image;
import com.example.txrollbacktest.post.port.PersistImagePort;
import com.example.txrollbacktest.repository.entity.ImageEntity;
import com.example.txrollbacktest.repository.entity.ImageJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
class PersistImageAdapter implements PersistImagePort {

    private final ImageJpaRepository imageJpaRepository;

    PersistImageAdapter(ImageJpaRepository imageJpaRepository) {
        this.imageJpaRepository = imageJpaRepository;
    }

    @Transactional
    @Override
    public Image save(Image image) {
        var entity = imageJpaRepository.save(ImageEntity.of(image));
        return new Image(entity.getPostId(), entity.getPath());
    }
}
