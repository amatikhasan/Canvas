package com.softsense.canvas

import com.softsense.canvas.domain.model.Post
import com.softsense.canvas.domain.usecase.GetPostsUseCase
import com.softsense.canvas.presentation.viewmodel.PostViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PostViewModelTest {

    private val getPostsUseCase: GetPostsUseCase = mockk()
    private val viewModel = PostViewModel(getPostsUseCase)

    @Test
    fun `fetchPosts updates posts state correctly`() = runTest {
        // Mock use case response
        val posts = listOf(
            Post(1, "Title 1", "Body 1", "User 1"),
            Post(2, "Title 2", "Body 2", "User 2")
        )
        coEvery { getPostsUseCase.execute() } returns flow { emit(posts) }

        // Call ViewModel function
        viewModel.fetchPosts()

        // Verify ViewModel state
        assertEquals(posts, viewModel.posts.value)
    }
}