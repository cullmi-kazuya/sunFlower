package com.example.sunflower.app.photo.ui

import com.example.sunflower.app.photo.data.logic.PhotoLogic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunflower.app.photo.data.data.PhotoEntity
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val logic: PhotoLogic
) :ViewModel() {

    fun inertPhoto(photo: PhotoEntity) = viewModelScope.launch(Dispatchers.IO) {
        logic.insertPhoto(photo)
    }
}