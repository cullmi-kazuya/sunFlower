package com.example.sunflower.app.photoList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.R
import com.example.sunflower.app.home.data.CellItem
import com.example.sunflower.app.home.ui.CustomCellAdapter
import com.example.sunflower.app.photoList.data.model.PhotoInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoListFragment : Fragment() {
    private val viewModel: PhotoListViewModel by viewModels()
    private lateinit var fruitsName: String
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.fruitsName = arguments?.getString("fruitsName") ?: ""
        viewModel.getPhotographerList(fruitsName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.recyclerView = view.findViewById(R.id.recyclerList)

        viewModel.photoList.observe(viewLifecycleOwner, Observer { photoList ->
            val cellItemList = convertToCellItemList(photoList)
            initRecycleView(cellItemList)
        })
    }

    private fun initRecycleView(cellItemList: List<CellItem>) {
        this.recyclerView.adapter = CustomCellAdapter(cellItemList)
        this.recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
    }

    private fun convertToCellItemList(photoList: List<PhotoInfo>): List<CellItem> {
        return photoList.map { photo ->
            CellItem(
                photo.username,
                photo.photoCellImageUrl
            )
        }
    }
}