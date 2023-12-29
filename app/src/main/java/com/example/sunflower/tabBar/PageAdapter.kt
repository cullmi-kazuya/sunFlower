package com.example.sunflower.tabBar

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sunflower.tabBar.favorites.ui.FavoritesFragment
import com.example.sunflower.tabBar.gallery.ui.GalleryFragment

class PageAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    private val fragmentListCount = 2

    override fun getItemCount(): Int {
        return fragmentListCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GalleryFragment()
            1 -> FavoritesFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}