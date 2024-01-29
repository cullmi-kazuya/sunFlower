package com.example.sunflower.app.photo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sunflower.app.photo.data.logic.PhotoLogic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunflower.app.photo.data.data.PhotoEntity
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val photoLogic: PhotoLogic
) :ViewModel() {

    private var _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    fun changeFavoriteState(photo: PhotoEntity) {
        if (_isFavorite.value!!) {
            deletePhoto(photo)
        } else {
            inertPhoto(photo)
        }
    }

    private fun inertPhoto(photo: PhotoEntity) = viewModelScope.launch(Dispatchers.IO) {
        photoLogic.insertPhoto(photo)
        withContext(Dispatchers.Main) {
            _isFavorite.value = true
        }
    }

    private fun deletePhoto(photo: PhotoEntity) = viewModelScope.launch(Dispatchers.IO) {
        photoLogic.delete(photo)
        withContext(Dispatchers.Main) {
            _isFavorite.value = false
        }
    }
    fun initFavoriteState(id: String) = viewModelScope.launch(Dispatchers.IO) {
        val photoList = photoLogic.getAllPhoto()
        val isFavorite = photoList.any { it.id == id }
        withContext(Dispatchers.Main) {
            _isFavorite.value = isFavorite
        }
    }
}