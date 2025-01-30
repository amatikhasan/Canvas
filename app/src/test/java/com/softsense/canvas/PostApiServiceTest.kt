package com.softsense.canvas

import com.google.gson.Gson
import com.softsense.canvas.data.remote.PostApiService
import com.softsense.canvas.data.remote.dto.PostDto
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals

class PostApiServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiService: PostApiService

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApiService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `getPosts returns correct data`() = runBlocking {
        val fakePosts = listOf(PostDto(1, 1, "Title 1", "Body 1"))
        val responseJson = Gson().toJson(fakePosts)

        mockWebServer.enqueue(MockResponse().setBody(responseJson).setResponseCode(200))

        val result = apiService.getPosts()

        assertEquals(1, result.size)
        assertEquals("Title 1", result[0].title)
    }
}