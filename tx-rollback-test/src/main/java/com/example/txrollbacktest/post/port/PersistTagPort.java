package com.example.txrollbacktest.post.port;

import com.example.txrollbacktest.post.domain.Tag;

public interface PersistTagPort {

    Tag save(Tag post);
}
