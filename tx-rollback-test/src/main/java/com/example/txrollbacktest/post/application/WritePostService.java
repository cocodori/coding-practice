package com.example.txrollbacktest.post.application;

import com.example.txrollbacktest.post.port.WritePostUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
class WritePostService implements WritePostUseCase {

    private final PostRegister postRegister;
    private final ImageRegister imageRegister;
    private final TagRegister tagRegister;

    WritePostService(
        PostRegister postRegister,
        ImageRegister imageRegister,
        TagRegister tagRegister
    ) {
        this.postRegister = postRegister;
        this.imageRegister = imageRegister;
        this.tagRegister = tagRegister;
    }

    @Transactional
    @Override
    public Long write(String title, String content, List<String> imgPaths, List<String> tags) {
        var post = postRegister.add(title, content);
        imageRegister.add(post.id(), imgPaths);
        tagRegister.add(post.id(), tags);
        throw new RuntimeException("test");
//        return post.id();
    }
}
