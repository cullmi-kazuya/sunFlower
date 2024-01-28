package com.example.sunflower.app.gallery.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.R
import com.example.sunflower.app.home.ui.RecyclerItemClickListener
import com.example.sunflower.app.gallery.data.FruitsInfo
import com.example.sunflower.app.home.data.CellItem
import com.example.sunflower.app.home.ui.CustomCellAdapter
import com.example.sunflower.app.home.ui.HomeTabFragmentDirections
import org.json.JSONArray
import java.io.InputStream

class GalleryFragment : Fragment() {

    private lateinit var itemList: List<FruitsInfo>

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val inputStream: InputStream = context.assets.open("fruits.json")
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        val jsonArray = JSONArray(jsonString)
        val dataList = mutableListOf<FruitsInfo>()

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val fruitId = jsonObject.getString("fruitId")
            val name = jsonObject.getString("name")
            val text = jsonObject.getString("text")
            val reference = jsonObject.getString("reference")
            val imageUrl = jsonObject.getString("imageUrl")
            dataList.add(FruitsInfo(fruitId, name, text, reference, imageUrl))
        }
        this.itemList = dataList
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.initRecycleView(recyclerView = view.findViewById(R.id.recyclerList))
    }

    private fun initRecycleView(recyclerView: RecyclerView) {
        val cellItemList = convertToCellItemList(itemList)
        recyclerView.adapter = CustomCellAdapter(cellItemList.toMutableList())
        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(requireContext(), recyclerView,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val fruits = itemList[position]
                        val action = HomeTabFragmentDirections.actionHomeTabFragmentToFruitsDetailFragment(
                            fruits.imageUrl,
                            fruits.name,
                            fruits.text
                        )
                        findNavController().navigate(action)
                    }
                }
            )
        )
    }

    private fun convertToCellItemList(fruitsInfoList: List<FruitsInfo>): List<CellItem> {
        return fruitsInfoList.map { fruitsInfo ->
            CellItem(
                fruitsInfo.name,
                fruitsInfo.imageUrl
            )
        }
    }
}