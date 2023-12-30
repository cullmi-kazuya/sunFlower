package com.example.sunflower.tabBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.sunflower.R
import com.example.sunflower.tabBar.favorites.ui.FavoritesFragment
import com.example.sunflower.tabBar.gallery.ui.GalleryFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.reflect.KClass

class HomeTabBarFragment(
    private val tabBarInfo: List<TabBarInfo> = TabBarInfo.create()
) : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private val tabTitleList: List<String> = this.tabBarInfo.map {
        it.tabTitle
    }
    private val tabFragmentClazzList: List<KClass<*>> = this.tabBarInfo.map {
        it.fragmentClazz
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_tab_bar, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)

        viewPager.adapter = PageAdapter(this, this.tabFragmentClazzList)
        TabLayoutMediator(tabLayout, viewPager) { myTabLayout, position ->
            myTabLayout.text = this.tabTitleList[position]
        }.attach()
    }
}