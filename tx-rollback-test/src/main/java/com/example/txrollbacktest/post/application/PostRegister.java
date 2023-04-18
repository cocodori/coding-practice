package com.example.txrollbacktest.post.application;

import com.example.txrollbacktest.post.domain.Post;
import com.example.txrollbacktest.post.port.PersistPostPort;
import org.springframework.stereotype.Component;

@Component
final class PostRegister {

    private final PersistPostPort persistPostPort;

    PostRegister(PersistPostPort persistPostPort) {
        this.persistPostPort = persistPostPort;
    }

    public Post add(String title, String content) {
        return persistPostPort.save(Post.of(title, content));
    }
}
