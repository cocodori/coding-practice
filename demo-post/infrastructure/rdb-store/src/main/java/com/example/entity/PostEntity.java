package com.example.entity;

import com.example.post.domain.Post;
import com.example.post.usecase.command.PostCreateCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String content;

    public static PostEntity withoutId(PostCreateCommand command) {
        return new PostEntity(command.title, command.content);
    }

    public PostEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long id() {
        return id;
    }
}
