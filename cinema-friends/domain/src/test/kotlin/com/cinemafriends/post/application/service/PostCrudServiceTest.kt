package com.cinemafriends.post.application.service

import com.cinemafriends.post.application.port.input.WritePostCommand
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
    val postCrudService = PostCrudService(postRegister)

    describe("write") {
        context("WritePostCommand가 주어지면") {
            val expectedPostId = Random().nextLong()
            every { postRegister.save(any()) } returns expectedPostId
            val command = WritePostCommand(
                title = "title",
                content = "content",
                author = "author"
            )

            it("PostRegister.save를 호출하고 PostId를 반환한다") {
                val actual = postCrudService.write(command)

                verify(exactly = 1) { postRegister.save(any()) }
                actual shouldBe expectedPostId
            }
        }
    }
})

