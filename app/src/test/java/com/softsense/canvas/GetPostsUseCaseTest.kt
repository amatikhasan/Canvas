package com.softsense.canvas

import com.softsense.canvas.domain.model.Post
import com.softsense.canvas.domain.repository.PostRepository
import com.softsense.canvas.domain.usecase.GetPostsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetPostsUseCaseTest {

    private val repository: PostRepository = mockk()
    private val useCase = GetPostsUseCase(repository)

    @Test
    fun `execute returns posts correctly`() = runTest {
        // Mock repository response
        val posts = listOf(
            Post(1, "Title 1", "Body 1", "User 1"),
            Post(2, "Title 2", "Body 2", "User 2")
        )
        coEvery { repository.getPosts() } returns flow { emit(posts) }

        // Call use case
        val result = useCase.execute().first()

        // Verify result
        assertEquals(posts, result)
    }
}