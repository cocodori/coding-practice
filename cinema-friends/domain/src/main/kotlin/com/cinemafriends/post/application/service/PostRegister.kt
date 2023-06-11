package com.cinemafriends.post.application.service

import com.cinemafriends.post.application.port.output.PersistPostPort
import com.cinemafriends.post.entity.Post
import org.springframework.stereotype.Component

@Component
class PostRegister(
    private val persistPostPort: PersistPostPort
) {
    fun save(post: Post): Long {
        val post = persistPostPort.persist(post)
        return post.id
    }
}