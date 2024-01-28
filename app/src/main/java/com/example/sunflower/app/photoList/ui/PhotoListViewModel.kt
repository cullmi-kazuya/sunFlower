package com.example.sunflower.app.photoList.ui

import androidx.lifecycle.ViewModel
import com.example.sunflower.app.photoList.data.logic.SearchPhotosLogic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val logic: SearchPhotosLogic
) : ViewModel() {

    fun getPhotographerList(fruitsName: String) = runBlocking {
        val result = logic.getPhotographerList(fruitsName)
    }
}