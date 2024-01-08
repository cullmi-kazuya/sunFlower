package com.example.sunflower.customCell.ui

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.sunflower.R
import java.net.URL

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
        this.image.setImageURI(Uri.parse(imageUrl))
    }

    fun setName(nameText: String) {
        this.nameText.text = nameText
    }
}