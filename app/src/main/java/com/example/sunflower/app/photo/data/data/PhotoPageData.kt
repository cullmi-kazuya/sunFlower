package com.example.sunflower.app.photo.data.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoPageData(
    val photoImageUrl: String,
    val photographerImageUrl: String,
    val photographerName: String,
    val photoText: String
) : Parcelable