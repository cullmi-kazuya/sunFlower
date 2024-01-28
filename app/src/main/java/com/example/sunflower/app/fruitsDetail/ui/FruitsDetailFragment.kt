package com.example.sunflower.app.fruitsDetail.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sunflower.R
import com.example.sunflower.app.home.ui.HomeTabFragmentDirections
import com.squareup.picasso.Picasso

class FruitsDetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fruits_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fruitsImageView = view.findViewById<ImageView>(R.id.fruitsImage)
        val imageUrl = arguments?.getString("imageUrl") ?: ""
        Picasso.get()
            .load(imageUrl)
            .into(fruitsImageView)

        val fruitsNameView = view.findViewById<TextView>(R.id.fruitsName)
        val fruitsName = arguments?.getString("fruitsName") ?: ""
        fruitsNameView.text = fruitsName

        val fruitsTextView = view.findViewById<TextView>(R.id.fruitsText)
        val fruitsText = arguments?.getString("fruitsText") ?: ""
        fruitsTextView.text = fruitsText

        val photographerButton = view.findViewById<ImageButton>(R.id.photographerButton)
        photographerButton.setOnClickListener {
            val action = FruitsDetailFragmentDirections
                .actionFruitsDetailFragmentToPhotoListFragment("Strawberry")
            Log.i("debug tap","hogehoge")
            findNavController().navigate(action)
        }
    }
}