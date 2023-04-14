package com.example.txrollbacktest.post.port;

import com.example.txrollbacktest.post.domain.Post;

public interface PersistPostPort {

    Post save(Post post);
}
