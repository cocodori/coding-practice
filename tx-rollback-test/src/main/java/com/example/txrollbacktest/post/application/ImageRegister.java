package com.example.txrollbacktest.post.application;

import com.example.txrollbacktest.post.domain.Image;
import com.example.txrollbacktest.post.port.PersistImagePort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
final class ImageRegister {

    private final PersistImagePort persistImagePort;

    public ImageRegister(PersistImagePort persistImagePort) {
        this.persistImagePort = persistImagePort;
    }

    public void add(Long id, List<String> imgPaths) {
        imgPaths.stream()
            .map(img -> new Image(id, img))
            .forEach(persistImagePort::save);
    }
}
