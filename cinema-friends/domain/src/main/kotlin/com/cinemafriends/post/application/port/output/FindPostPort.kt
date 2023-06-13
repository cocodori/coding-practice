package com.cinemafriends.post.application.port.output

import com.cinemafriends.post.entity.Post

interface FindPostPort {

    fun find(id: Long): Post?
}