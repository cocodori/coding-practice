package com.cinemafriends.post.application.service

import com.cinemafriends.post.application.exception.PostNotFoundException
import com.cinemafriends.post.application.port.output.FindPostPort
import com.cinemafriends.post.entity.Post
import org.springframework.stereotype.Component

@Component
class PostFinder(
    private val findPostPort: FindPostPort
) {

    fun get(id: Long): Post =
        findPostPort.find(id)
            ?: throw PostNotFoundException(id)
}
