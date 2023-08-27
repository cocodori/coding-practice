package com.cinemafriends.post.application.service

import com.cinemafriends.post.application.port.output.DeletePostPort
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import java.util.Random

@ExtendWith(MockKExtension::class)
class PostDeleterTest : DescribeSpec({
    val deletePostPort: DeletePostPort = mockk()
    val postDeleter = PostDeleter(deletePostPort)

    describe("delete") {
        context("postId가 주어지면") {
            justRun { postDeleter.delete(any()) }
            val id = Random().nextLong()
            postDeleter.delete(id)

            it("deletePostPort.delete 콜한다") {
                verify(exactly = 1) { deletePostPort.delete(id) }
            }
        }

    }
}) {

}