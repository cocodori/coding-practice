package com.cinemafriends.post.application.port.input

interface WritePostUseCase {

    fun write(command: WritePostCommand): Long
}