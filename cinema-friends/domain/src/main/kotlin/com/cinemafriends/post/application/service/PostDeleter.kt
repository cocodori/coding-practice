package com.cinemafriends.post.application.service

import com.cinemafriends.post.application.port.output.DeletePostPort
import org.springframework.stereotype.Component

@Component
class PostDeleter(
    private val deletePostPort: DeletePostPort
) {

    fun delete(id: Long) {
        deletePostPort.delete(id)
    }
}