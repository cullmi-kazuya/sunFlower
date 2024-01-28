package com.example.sunflower.app.photoList.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sunflower.app.photoList.data.logic.SearchPhotosLogic
import com.example.sunflower.app.photoList.data.model.Photo
import com.example.sunflower.app.photoList.data.model.PhotoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val logic: SearchPhotosLogic
) : ViewModel() {

    private var _photoList = MutableLiveData<List<PhotoInfo>>()
    val photoList: LiveData<List<PhotoInfo>> get() = _photoList

    fun getPhotographerList(fruitsName: String) = runBlocking {
        val response = logic.getPhotographerList(fruitsName)
        val photoList = createPhotoInfoList(response.results)
        _photoList.value = photoList
    }

    private fun createPhotoInfoList(photoList: List<Photo>): List<PhotoInfo> {
        return photoList.map { photo ->
            Log.i("hogehoge", photo.toString())
            PhotoInfo(
                id = photo.id,
                userId = photo.user.id,
                username = photo.user.username,
//                profileImageUrl = photo.user.profileImage.medium,
                photoCellImageUrl = photo.urls.small // ここで適切な写真の画像サイズを選択
            )
        }
    }
}