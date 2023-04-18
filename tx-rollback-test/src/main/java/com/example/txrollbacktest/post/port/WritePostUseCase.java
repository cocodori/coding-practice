package com.example.txrollbacktest.post.port;

import java.util.List;

public interface WritePostUseCase {
    Long write(
        String title,
        String content,
        List<String> imgPaths,
        List<String> tags
    );
}
