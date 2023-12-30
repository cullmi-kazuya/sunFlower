package com.example.sunflower.tabBar

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sunflower.tabBar.favorites.ui.FavoritesFragment
import com.example.sunflower.tabBar.gallery.ui.GalleryFragment
import kotlin.reflect.KClass

class PageAdapter(
    fragment: Fragment,
    private val tabFragmentList: List<KClass<*>>
): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return this.tabFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return this.tabFragmentList[position].java.newInstance() as Fragment
    }
}