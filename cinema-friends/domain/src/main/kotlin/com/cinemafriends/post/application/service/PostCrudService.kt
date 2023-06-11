package com.cinemafriends.post.application.service

import com.cinemafriends.post.application.port.input.WritePostCommand
import com.cinemafriends.post.application.port.input.WritePostUseCase
import org.springframework.stereotype.Service

@Service
class PostCrudService(
    private val register: PostRegister
) : WritePostUseCase {

    override fun write(command: WritePostCommand): Long {
        return register.save(command.toDomain())
    }
}