package com.cinemafriends.post.application.service

import com.cinemafriends.post.application.exception.PostNotFoundException
import com.cinemafriends.post.application.port.output.FindPostPort
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.string.shouldContain
import io.mockk.every
import io.mockk.mockk
import java.util.Random

class PostFinderTest : DescribeSpec({
    val findPostPort = mockk<FindPostPort>()
    val postFinder = PostFinder(findPostPort)

    describe("get") {
        context("postId가 주어질 때") {
            val postId = Random().nextLong()
            every { findPostPort.find(any()) } throws PostNotFoundException(postId)

            it("매칭되는 Post가 없다면 PostNotFoundException 발생한다") {
                val actualThrow = shouldThrow<PostNotFoundException> { postFinder.get(postId) }
                actualThrow.message shouldContain "$postId"
            }
        }
    }
})