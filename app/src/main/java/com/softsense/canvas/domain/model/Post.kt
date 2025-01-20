package com.softsense.canvas.domain.model

data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val user: String // Name of the user
)