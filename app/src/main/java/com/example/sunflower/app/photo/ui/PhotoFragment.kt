package com.example.sunflower.app.photo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sunflower.R
import com.squareup.picasso.Picasso

class PhotoFragment : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val photoImageView = view.findViewById<ImageView>(R.id.photoImage)
        val photoImageUrl = arguments?.getString("photoImageUrl") ?: ""
        Picasso.get()
            .load(photoImageUrl)
            .into(photoImageView)

        val photographerImageView = view.findViewById<ImageView>(R.id.photographerImage)
        val photographerImageUrl = arguments?.getString("photographerImageUrl") ?: ""
        Picasso.get()
            .load(photographerImageUrl)
            .into(photographerImageView)

        val photographerNameText = view.findViewById<TextView>(R.id.photographerName)
        val photographerName = arguments?.getString("photographerName") ?: ""
        photographerNameText.text = photographerName

        val photoTextView = view.findViewById<TextView>(R.id.photoText)
        val photoText = arguments?.getString("photoText") ?: ""
        photoTextView.text = photoText

        val favoriteButton = view.findViewById<ImageButton>(R.id.favoriteButton)

    }
}