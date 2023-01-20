package com.example.post.domain;

import com.example.post.domain.code.TagType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Tag {
    Long id;
    String name;

    TagType type;
}
