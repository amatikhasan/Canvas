package com.softsense.canvas.data.remote

import retrofit2.http.GET
import com.softsense.canvas.data.remote.dto.*

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>

    @GET("users")
    suspend fun getUsers(): List<UserDto>
}