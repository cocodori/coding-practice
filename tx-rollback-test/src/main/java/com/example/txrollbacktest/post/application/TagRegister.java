package com.example.txrollbacktest.post.application;

import com.example.txrollbacktest.post.domain.Tag;
import com.example.txrollbacktest.post.port.PersistTagPort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
final class TagRegister {

    private final PersistTagPort persistTagPort;

    public TagRegister(PersistTagPort persistTagPort) {
        this.persistTagPort = persistTagPort;
    }

    public void add(Long postId, List<String> tags) {
        tags.stream()
            .map(name -> new Tag(postId, name))
            .forEach(persistTagPort::save);
    }
}
