package com.example.post.adapter.in;

import com.example.post.adapter.in.dto.PostCreateRequest;
import com.example.post.usecase.PostCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostCreateController {

    private final PostCreateUseCase useCase;

    @PostMapping("/api/v1/post")
    Long createPost(@RequestBody PostCreateRequest request) {
        Long postId = useCase.create(request.toCommand());

        return postId;
    }

}
