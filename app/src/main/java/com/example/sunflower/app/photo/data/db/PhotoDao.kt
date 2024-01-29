package com.example.sunflower.app.photo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunflower.app.photo.data.data.PhotoEntity

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotoInfo(photoEntity: PhotoEntity)

    @Query("SELECT * FROM photo_table")
    suspend fun getAllPhotoInfo(): List<PhotoEntity>
}