package com.softsense.canvas

import com.softsense.canvas.data.remote.PostApiService
import com.softsense.canvas.data.remote.dto.PostDto
import com.softsense.canvas.data.remote.dto.UserDto
import com.softsense.canvas.data.repository.PostRepositoryImpl
import com.softsense.canvas.domain.model.Post
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class PostRepositoryImplTest {

    private val apiService: PostApiService = mockk()
    private val repository = PostRepositoryImpl(apiService)

    @Test
    fun `getPosts combines posts with user names correctly`() = runBlocking {
        // Mock API responses
        val posts = listOf(
            PostDto(1, 1, "Title 1", "Body 1"),
            PostDto(2, 2, "Title 2", "Body 2")
        )
        val users = listOf(
            UserDto(1, "User 1"),
            UserDto(2, "User 2")
        )

        coEvery { apiService.getPosts() } returns posts
        coEvery { apiService.getUsers() } returns users

        // Test repository
        val result = repository.getPosts().first()

        // Verify result
        val expected = listOf(
            Post(1, "Title 1", "Body 1", "User 1"),
            Post(2, "Title 2", "Body 2", "User 2")
        )
        assertEquals(expected, result)
    }
}