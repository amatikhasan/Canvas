package com.softsense.canvas.domain.repository

import com.softsense.canvas.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(): Flow<List<Post>>
}