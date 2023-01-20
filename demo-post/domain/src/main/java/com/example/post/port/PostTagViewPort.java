package com.example.post.port;

import com.example.post.domain.Tag;

import java.util.Set;

public interface PostTagViewPort {
    Set<Tag> findAllHashtagByNames(Set<String> names);
}
