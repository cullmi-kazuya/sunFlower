package com.example.sunflower.app.favorite.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.R
import com.example.sunflower.app.home.data.CellItem
import com.example.sunflower.app.home.ui.CustomCellAdapter
import com.example.sunflower.app.home.ui.RecyclerItemClickListener
import com.example.sunflower.app.photo.data.data.PhotoEntity
import com.example.sunflower.app.photoList.ui.PhotoListFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private val viewModel: FavoriteViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private var photoList: MutableList<PhotoEntity> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.recyclerView = view.findViewById(R.id.favoriteRecyclerList)
        initRecycleView()

        viewModel.photoList.observe(viewLifecycleOwner, Observer { photoList ->
            this.photoList = photoList.toMutableList()
            val cellItemList = convertToCellItemList(photoList)
            val adapter = this.recyclerView.adapter as CustomCellAdapter
            adapter.setData(cellItemList)
        })
        viewModel.getAllPhoto()
    }

    private fun initRecycleView() {
        this.recyclerView.adapter = CustomCellAdapter()
        this.recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(requireContext(), recyclerView,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val photo = photoList[position]
                        val action = PhotoListFragmentDirections.actionPhotoListFragmentToPhotoFragment(
                            photo
                        )
                        findNavController().navigate(action)
                    }
                }
            )
        )
    }

    private fun convertToCellItemList(photoList: List<PhotoEntity>): List<CellItem>  {
        return photoList.map { photo ->
            CellItem(
                photo.username,
                photo.photoCellImageUrl
            )
        }
    }
}