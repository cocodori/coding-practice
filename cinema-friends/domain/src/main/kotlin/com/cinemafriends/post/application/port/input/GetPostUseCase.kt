package com.cinemafriends.post.application.port.input

import com.cinemafriends.post.entity.Post

interface GetPostUseCase {

    /**
     * @throws PostNotFoundException
     */
    fun get(id: Long): Post
}