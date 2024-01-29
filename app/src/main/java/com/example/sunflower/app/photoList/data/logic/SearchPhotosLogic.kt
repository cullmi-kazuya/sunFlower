package com.example.sunflower.app.photoList.data.logic

import com.example.sunflower.app.photoList.data.api.UnsplashApiService
import com.example.sunflower.app.photo.data.db.PhotoRepository
import com.example.sunflower.app.photoList.data.data.PhotoInfo
import com.example.sunflower.app.photoList.data.data.UnsplashSearchPhotosResponse
import javax.inject.Inject

class SearchPhotosLogic @Inject constructor(
    private val apiService: UnsplashApiService
) {

    private val perPage = 20

    suspend fun getPhotographerList(
        fruitsName: String,
        pageCount: Int
    ): UnsplashSearchPhotosResponse {
        try {
            return apiService.getRandomPhoto(
                fruitsName,
                pageCount,
                perPage
            )
        } catch (e: Exception) {
            throw e
        }
    }
}