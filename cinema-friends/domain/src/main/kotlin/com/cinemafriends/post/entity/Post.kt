package com.cinemafriends.post.entity

import java.time.LocalDateTime

class Post(
    id: Long? = null,
    val title: String,
    val content: String,
    val author: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    private val noneId = -9999L
    val id: Long = id ?: noneId
}