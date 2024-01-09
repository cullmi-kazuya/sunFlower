package com.example.sunflower.home.gallery.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.R
import com.example.sunflower.core.adapter.RecyclerItemClickListener
import com.example.sunflower.customCell.data.FruitCellItem
import com.example.sunflower.customCell.ui.CustomCellAdapter
import org.json.JSONArray
import java.io.InputStream

class GalleryFragment : Fragment() {

    private lateinit var itemList: List<FruitCellItem>

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val inputStream: InputStream = context.assets.open("fruits.json")
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
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
        this.itemList = dataList
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerList)
        recyclerView.adapter = CustomCellAdapter(itemList)
        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)

        recyclerView.addOnItemTouchListener(RecyclerItemClickListener(requireContext(), recyclerView,
            object: RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    Log.i("sample", "click ${position}")
                }
            })
        )
        return view
    }
}