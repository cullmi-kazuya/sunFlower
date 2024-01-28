package com.example.sunflower.app.photoList.data.logic

import com.example.sunflower.app.photoList.data.api.UnsplashApiService
import com.example.sunflower.app.photoList.data.model.UnsplashSearchPhotosResponse
import javax.inject.Inject

class SearchPhotosLogic @Inject constructor(
    private val apiService: UnsplashApiService
) {
    suspend fun getPhotographerList(fruitsName: String): UnsplashSearchPhotosResponse {
        try {
            val response = apiService.getRandomPhoto(
                fruitsName,
                1,
                16
            )
            return response
        } catch (e: Exception) {
            throw e
        }
    }
}