package com.example.sunflower.app.photoList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.R
import com.example.sunflower.app.home.data.CellItem
import com.example.sunflower.app.home.ui.CustomCellAdapter
import com.example.sunflower.app.home.ui.RecyclerItemClickListener
import com.example.sunflower.app.home.ui.RecyclerScrollListener
import com.example.sunflower.app.photo.data.data.PhotoEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoListFragment : Fragment() {

    private val viewModel: PhotoListViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private val photoList: MutableList<PhotoEntity> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.clear()
        val fruitsName = arguments?.getString("fruitsName") ?: ""
        viewModel.setFruitsName(fruitsName)

        return inflater.inflate(R.layout.fragment_photo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.recyclerView = view.findViewById(R.id.recyclerList)
        initRecycleView()

        viewModel.photoList.observe(viewLifecycleOwner, Observer { photoList ->
            this.photoList.addAll(photoList)
            val cellItemList = convertToCellItemList(photoList)
            val adapter = this.recyclerView.adapter as CustomCellAdapter
            adapter.addData(cellItemList)
        })
        viewModel.getPhotoList()
    }

    private fun initRecycleView() {
        this.recyclerView.adapter = CustomCellAdapter()

        val layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        this.recyclerView.layoutManager = layoutManager
        val scrollListener = RecyclerScrollListener(layoutManager) {
            viewModel.getPhotoList()
        }
        recyclerView.addOnScrollListener(scrollListener)
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

    private fun convertToCellItemList(photoList: List<PhotoEntity>): List<CellItem> {
        return photoList.map { photo ->
            CellItem(
                photo.username,
                photo.photoCellImageUrl
            )
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.clear()
    }
}