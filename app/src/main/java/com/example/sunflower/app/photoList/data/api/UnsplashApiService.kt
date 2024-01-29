package com.example.sunflower.app.photoList.data.api

import com.example.sunflower.app.photoList.data.data.UnsplashSearchPhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {

    @GET("search/photos")
    suspend fun getRandomPhoto(
        @Query("query") fruitsName: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("order_by") orderBy: String = "relevant"
    ): UnsplashSearchPhotosResponse
}