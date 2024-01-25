package com.example.sunflower.app.photographerList.data.api

import com.example.sunflower.app.photographerList.data.model.UnsplashSearchPhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("query") query: String
    ): UnsplashSearchPhotoResponse
}