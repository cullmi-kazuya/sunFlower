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
import androidx.lifecycle.Observer
import com.example.sunflower.R
import com.example.sunflower.app.photo.data.data.PhotoEntity
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

        val photo: PhotoEntity = arguments?.getParcelable("photoData")!!

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
            viewModel.changeFavoriteState(photo)
        }
        viewModel.isFavorite.observe(viewLifecycleOwner, Observer { isFavorite ->
            if (isFavorite) {
                favoriteButton.setImageResource(android.R.drawable.btn_star_big_on)
            } else {
                favoriteButton.setImageResource(android.R.drawable.btn_star_big_off)
            }
        })
        viewModel.initFavoriteState(photo.id)
    }
}