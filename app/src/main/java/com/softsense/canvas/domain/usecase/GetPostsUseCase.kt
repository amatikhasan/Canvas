package com.softsense.canvas.domain.usecase

import com.softsense.canvas.domain.model.Post
import com.softsense.canvas.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsUseCase(private val repository: PostRepository) {
    fun execute(): Flow<List<Post>> = repository.getPosts()
}