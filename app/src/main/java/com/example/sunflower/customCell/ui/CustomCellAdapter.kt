package com.example.sunflower.customCell.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.R
import com.example.sunflower.customCell.data.FruitCellItem

class CustomCellAdapter(private val dataList: List<FruitCellItem>):
    RecyclerView.Adapter<CustomCellAdapter.ViewHolder>()
{
        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val customCellView: CustomCellView = itemView.findViewById(R.id.customCellView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_custom_relative_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = dataList[position]
            holder.customCellView.setImage(item.imageUrl)
            holder.customCellView.setName(item.name)
        }

        override fun getItemCount(): Int {
            return dataList.size
        }
}