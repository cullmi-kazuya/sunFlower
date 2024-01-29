package com.example.sunflower.app.photo.data.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_table")
data class PhotoEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val username: String,
    val photoCellImageUrl: String,
    val photoImageUrl: String,
    val photographerImageUrl: String,
    val photoText: String
)