package com.example.sunflower.app.favorite.logic

import com.example.sunflower.app.photo.data.data.PhotoEntity
import com.example.sunflower.core.db.photo.PhotoRepository
import javax.inject.Inject

class FavoriteLogic @Inject constructor(
    private val dbRepository: PhotoRepository
) {
    suspend fun getAllPhoto(): List<PhotoEntity> {
        return dbRepository.getAllPhotoInfo()
    }
}