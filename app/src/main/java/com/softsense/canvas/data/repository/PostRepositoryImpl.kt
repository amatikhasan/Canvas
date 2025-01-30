package com.softsense.canvas.data.repository

import com.softsense.canvas.data.remote.PostApiService
import com.softsense.canvas.data.remote.dto.PostDto
import com.softsense.canvas.data.remote.dto.UserDto
import com.softsense.canvas.domain.model.Post
import com.softsense.canvas.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val apiService: PostApiService) : PostRepository {
    override fun getPosts(): Flow<List<Post>> = flow {
        val users = apiService.getUsers()
        val posts = apiService.getPosts()

        val userMap = users.associateBy(UserDto::id)
        val combinedPosts = posts.map { postDto ->
            val userName = userMap[postDto.userId]?.name ?: "Unknown User"
            Post(
                id = postDto.id,
                title = postDto.title,
                body = postDto.body,
                user = userName
            )
        }

        emit(combinedPosts)
    }
}