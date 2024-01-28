package com.example.sunflower.di

import com.example.sunflower.app.photoList.data.api.UnsplashApiService
import com.example.sunflower.app.photoList.data.api.UnsplashApiBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    fun provideApiService(): UnsplashApiService {
        return UnsplashApiBuilder.create()
    }
}