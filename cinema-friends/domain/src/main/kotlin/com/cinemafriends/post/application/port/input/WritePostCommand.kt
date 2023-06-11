package com.cinemafriends.post.application.port.input

import com.cinemafriends.post.entity.Post

data class WritePostCommand(
    val title: String,
    val content: String,
    val author: String
) {
    fun toDomain() = Post(
        title = title,
        content = content,
        author = author
    )
}