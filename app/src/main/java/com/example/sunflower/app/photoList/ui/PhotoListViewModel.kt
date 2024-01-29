package com.example.sunflower.app.photoList.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sunflower.app.photo.data.data.PhotoEntity
import com.example.sunflower.app.photoList.data.logic.SearchPhotosLogic
import com.example.sunflower.app.photoList.data.data.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val logic: SearchPhotosLogic
) : ViewModel() {

    private var _photoList = MutableLiveData<List<PhotoEntity>>()
    val photoList: LiveData<List<PhotoEntity>> get() = _photoList

    private var pageCount = 0;
    private var fruitsName: String = ""

    fun setFruitsName(fruitsName: String) {
        this.fruitsName = fruitsName
    }
    fun getPhotoList() = runBlocking {
        val response = logic.getPhotographerList(
            fruitsName,
            pageCount
        )
        pageCount ++

        val photoList = createPhotoInfoList(response.results)
        _photoList.value = photoList
    }

    private fun createPhotoInfoList(photoList: List<Photo>): List<PhotoEntity> {
        return photoList.map { photo ->
            PhotoEntity(
                id = photo.id,
                userId = photo.user.id,
                username = photo.user.name,
                photoCellImageUrl = photo.urls.small,
                photoImageUrl = photo.urls.regular,
                photographerImageUrl = photo.urls.small, // 仮
                photoText = "hogehoge"
            )
        }
    }

    fun clear() {
        this.pageCount = 0
        this.fruitsName = ""
    }
}