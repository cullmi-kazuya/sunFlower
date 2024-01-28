package com.example.sunflower.app.home.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.R
import com.example.sunflower.app.home.data.CellItem

class CustomCellAdapter(
    private val dataList: MutableList<CellItem> = mutableListOf()
): RecyclerView.Adapter<CustomCellAdapter.ViewHolder>() {

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
        holder.customCellView.setName(item.titleText)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(newData: List<CellItem>) {
        dataList.addAll(newData)
        notifyDataSetChanged()
    }
}