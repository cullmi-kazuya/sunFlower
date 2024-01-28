package com.example.sunflower.app.photographerList.data

import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashService {

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("query") query: String
    ): UnsplashSearchPhotoResponse
}