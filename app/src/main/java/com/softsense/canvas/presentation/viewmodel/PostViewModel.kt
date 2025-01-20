package com.softsense.canvas.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softsense.canvas.domain.model.Post
import com.softsense.canvas.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor (private val getPostsUseCase: GetPostsUseCase) : ViewModel() {
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts.asStateFlow()

    fun fetchPosts() {
        viewModelScope.launch {
            getPostsUseCase.execute().collect { postList ->
                _posts.value = postList
            }
        }
    }
}