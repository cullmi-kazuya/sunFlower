package com.example.sunflower.home.gallery.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.R
import com.example.sunflower.customCell.data.FruitCellItem
import com.example.sunflower.customCell.ui.CustomCellAdapter
import org.json.JSONArray

class GalleryFragment : Fragment() {

    private val itemList: List<FruitCellItem> = run {
        val jsonString = context?.assets?.open("fruits.json")?.bufferedReader().use {
            it?.readText() ?: ""
        }
        val jsonArray = JSONArray(jsonString)
        val dataList = mutableListOf<FruitCellItem>()

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val fruitId = jsonObject.getString("fruitId")
            val name = jsonObject.getString("name")
            val text = jsonObject.getString("text")
            val reference = jsonObject.getString("reference")
            val imageUrl = jsonObject.getString("imageUrl")
            dataList.add(FruitCellItem(fruitId, name, text, reference, imageUrl))
        }
        dataList
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerList)
        recyclerView.adapter = CustomCellAdapter(itemList)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)

        return view
    }
}