package com.example.sunflower.app.photo.data.logic

import com.example.sunflower.app.photo.data.data.PhotoEntity
import com.example.sunflower.app.photo.data.db.PhotoRepository
import javax.inject.Inject


class PhotoLogic @Inject constructor(
    private val dbRepository: PhotoRepository
) {
    suspend fun insertPhoto(photoEntity: PhotoEntity) {
        dbRepository.insertPhotoInfo(photoEntity)
    }

    suspend fun getAllPhoto(): List<PhotoEntity> {
        return dbRepository.getAllPhotoInfo()
    }
}