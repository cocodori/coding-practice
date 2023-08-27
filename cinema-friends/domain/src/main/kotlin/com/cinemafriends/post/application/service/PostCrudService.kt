package com.cinemafriends.post.application.service

import com.cinemafriends.post.application.port.input.DeletePostUseCase
import com.cinemafriends.post.application.port.input.GetPostUseCase
import com.cinemafriends.post.application.port.input.WritePostCommand
import com.cinemafriends.post.application.port.input.WritePostUseCase
import com.cinemafriends.post.entity.Post
import org.springframework.stereotype.Service

@Service
class PostCrudService(
    private val register: PostRegister,
    private val postFinder: PostFinder,
    private val postDeleter: PostDeleter
) : WritePostUseCase,
    GetPostUseCase,
    DeletePostUseCase {

    override fun write(command: WritePostCommand): Long {
        return register.save(command.toDomain())
    }

    override fun get(id: Long): Post {
        return postFinder.get(id);
    }

    override fun delete(id: Long) {
        postDeleter.delete(id)
    }
}