package com.example.txrollbacktest.repository.entity;

import com.example.txrollbacktest.post.domain.Tag;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;
    private String name;

    public static TagEntity of(Tag tag) {
        return new TagEntity(tag.postId(), tag.name());
    }

    private TagEntity(Long postId, String name) {
        this.postId = postId;
        this.name = name;
    }

    protected TagEntity() {
    }

    public Long getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }
}
