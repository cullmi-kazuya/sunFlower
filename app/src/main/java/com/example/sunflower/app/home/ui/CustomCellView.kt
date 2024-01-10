package com.example.sunflower.app.home.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.sunflower.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CustomCellView(
    context: Context,
    attributeSet: AttributeSet,
): ConstraintLayout(context, attributeSet) {

    private val image: ImageView
    private val nameText: TextView

    init {
        View.inflate(context, R.layout.view_custom_cell, this)
        this.image = findViewById(R.id.image)
        this.nameText = findViewById(R.id.name_text)
    }

    fun setImage(imageUrl: String) {
        Picasso.get()
            .load(imageUrl)
            .into(this.image)
    }

    fun setName(nameText: String) {
        this.nameText.text = nameText
    }
}