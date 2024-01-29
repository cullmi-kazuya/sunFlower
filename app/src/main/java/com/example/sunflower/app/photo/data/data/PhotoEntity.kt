package com.example.sunflower.app.photo.data.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "photo_table")
data class PhotoEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val username: String,
    val photoCellImageUrl: String,
    val photoImageUrl: String,
    val photographerImageUrl: String,
    val photoText: String
) : Parcelable