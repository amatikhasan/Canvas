package com.softsense.canvas.di

import com.softsense.canvas.data.remote.PostApiService
import com.softsense.canvas.data.repository.PostRepositoryImpl
import com.softsense.canvas.domain.repository.PostRepository
import com.softsense.canvas.domain.usecase.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePostApiService(retrofit: Retrofit): PostApiService =
        retrofit.create(PostApiService::class.java)

    @Provides
    @Singleton
    fun providePostRepository(apiService: PostApiService): PostRepository =
        PostRepositoryImpl(apiService)

    @Provides
    fun provideGetPostsUseCase(repository: PostRepository): GetPostsUseCase =
        GetPostsUseCase(repository)
}