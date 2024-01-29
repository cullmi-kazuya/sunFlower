package com.example.sunflower.app.favorite.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunflower.app.photo.data.data.PhotoEntity
import com.example.sunflower.app.photo.data.logic.PhotoLogic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val logic: PhotoLogic
) : ViewModel()  {

    private var _photoList = MutableLiveData<List<PhotoEntity>>()
    val photoList: LiveData<List<PhotoEntity>> get() = _photoList

    fun getAllPhoto() = viewModelScope.launch(Dispatchers.IO) {
        val photoList = logic.getAllPhoto()
        withContext(Dispatchers.Main) {
            _photoList.value = photoList
        }
    }
}