package com.example.sunflower.core.db.photo

import com.example.sunflower.app.photo.data.data.PhotoEntity
import com.example.sunflower.core.db.photo.PhotoDao
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

    suspend fun delete(id: String) {
        return photoInfoDao.deletePhotoById(id)
    }
}