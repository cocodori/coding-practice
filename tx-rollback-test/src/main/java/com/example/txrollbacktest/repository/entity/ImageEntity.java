package com.example.txrollbacktest.repository.entity;

import com.example.txrollbacktest.post.domain.Image;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;
    private String path;

    public static ImageEntity of(Image image) {
        return new ImageEntity(image.id(), image.path());
    }

    public ImageEntity(Long postId, String path) {
        this.postId = postId;
        this.path = path;
    }

    protected ImageEntity() {
    }

    public Long getPostId() {
        return postId;
    }

    public String getPath() {
        return path;
    }
}
