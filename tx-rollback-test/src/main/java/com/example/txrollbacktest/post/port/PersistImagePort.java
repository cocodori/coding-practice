package com.example.txrollbacktest.post.port;

import com.example.txrollbacktest.post.domain.Image;

public interface PersistImagePort {

    Image save(Image post);
}
