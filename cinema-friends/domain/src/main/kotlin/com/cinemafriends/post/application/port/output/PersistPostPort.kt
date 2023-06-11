package com.cinemafriends.post.application.port.output

import com.cinemafriends.post.entity.Post

interface PersistPostPort {
    fun persist(post: Post): Post
}