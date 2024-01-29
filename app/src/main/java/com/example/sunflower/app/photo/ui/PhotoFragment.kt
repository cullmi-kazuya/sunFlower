package com.example.sunflower.app.photo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sunflower.R
import com.example.sunflower.app.fruitsDetail.ui.FruitsDetailFragmentDirections
import com.example.sunflower.app.photo.data.data.PhotoEntity
import com.example.sunflower.app.photo.data.data.PhotoPageData
import com.example.sunflower.app.photoList.data.data.PhotoInfo
import com.example.sunflower.app.photoList.ui.PhotoListViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : Fragment() {
    private val viewModel: PhotoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val photo: PhotoInfo = arguments?.getParcelable("photoData")!!

        val photoImageView = view.findViewById<ImageView>(R.id.photoImage)
        val photoImageUrl = photo.photoImageUrl
        Picasso.get()
            .load(photoImageUrl)
            .into(photoImageView)

        val photographerImageView = view.findViewById<ImageView>(R.id.photographerImage)
        val photographerImageUrl = photo.photographerImageUrl
        Picasso.get()
            .load(photographerImageUrl)
            .into(photographerImageView)

        val photographerNameText = view.findViewById<TextView>(R.id.photographerName)
        val photographerName = photo.username
        photographerNameText.text = photographerName

        val photoTextView = view.findViewById<TextView>(R.id.photoText)
        val photoText = photo.photoText
        photoTextView.text = photoText

        val favoriteButton = view.findViewById<ImageButton>(R.id.favoriteButton)
        favoriteButton.setOnClickListener {
            val entity = PhotoEntity(
                photo.id,
                photo.userId,
                photo.username,
                photo.photoCellImageUrl,
                photo.photoImageUrl,
                photo.photographerImageUrl,
                photo.photoText
            )
            viewModel.inertPhoto(entity)
        }
    }
}