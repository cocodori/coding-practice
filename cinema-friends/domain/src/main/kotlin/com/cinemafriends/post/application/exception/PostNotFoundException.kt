package com.cinemafriends.post.application.exception

class PostNotFoundException(
    id: Long
) : RuntimeException("PostNotFound PostId: $id")