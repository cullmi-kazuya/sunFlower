package com.example.sunflower.app.photo.data.db

import com.example.sunflower.app.photo.data.data.PhotoEntity
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val photoInfoDao: PhotoDao
) {
    suspend fun insertPhotoInfo(photoEntity: PhotoEntity) {
        photoInfoDao.insertPhotoInfo(photoEntity)
    }

    suspend fun getAllPhotoInfo(): List<PhotoEntity> {
        return photoInfoDao.getAllPhotoInfo()
    }
}