package com.example.sunflower.app.photoList.data.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PhotoInfo(
    val id: String,
    val userId: String,
    val username: String,
    val photoCellImageUrl: String,
    val photoImageUrl: String,
    val photographerImageUrl: String,
    val photoText: String
) : Parcelable