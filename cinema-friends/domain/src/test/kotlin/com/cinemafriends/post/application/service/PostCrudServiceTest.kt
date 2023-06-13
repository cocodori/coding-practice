package com.cinemafriends.post.application.service

import com.cinemafriends.post.application.port.input.WritePostCommand
import com.cinemafriends.post.entity.Post
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.extension.ExtendWith
import java.util.Random


@ExtendWith(MockKExtension::class)
internal class PostCrudServiceDescribeSpec : DescribeSpec({
    val postRegister: PostRegister = mockk()
    val postFinder: PostFinder = mockk()
    val postCrudService = PostCrudService(
        postRegister,
        postFinder
    )

    describe("write") {
        context("WritePostCommand가 주어지면") {
            val expectedPostId = Random().nextLong()
            every { postRegister.save(any()) } returns expectedPostId
            val command = writePostCommand()

            it("PostRegister.save를 호출하고 PostId를 반환한다") {
                val actual = postCrudService.write(command)

                verify(exactly = 1) { postRegister.save(any()) }
                actual shouldBe expectedPostId
            }
        }
    }

    describe("get") {
        context("postId가 주어지면") {
            val postId = Random().nextLong()
            val expected = post(postId)
            every { postFinder.get(postId) } returns expected

            it("매칭되는 Post 반환한다") {
                val actual = postCrudService.get(postId)

                verify(exactly = 1) { postFinder.get(postId) }
                actual shouldBe expected
            }
        }
    }
})

private fun writePostCommand() = WritePostCommand(
    title = "title",
    content = "content",
    author = "author"
)

private fun post(postId: Long) = Post(
    id = postId,
    title = "title",
    content = "content",
    author = "author"
)

