package com.example.txrollbacktest.repository.entity;

import com.example.txrollbacktest.post.domain.Post;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    public static PostEntity of(Post post) {
        return new PostEntity(post.title(), post.content());
    }

    private PostEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

    protected PostEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
