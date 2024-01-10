package com.example.sunflower.app.home.data

import com.example.sunflower.app.favorite.ui.FavoritesFragment
import com.example.sunflower.app.gallery.ui.GalleryFragment
import kotlin.reflect.KClass

sealed class TabBarInfo(
    val fragmentClazz: KClass<*>,
    val tabTitle: String
) {


    class Gallery: TabBarInfo(
        GalleryFragment::class,
        "Gallery"
//        R.string.gallery_title
    )

    class Favorite: TabBarInfo(
        FavoritesFragment::class,
        "Favorite"
//        R.string.favorite_title
    )

    companion object {
        fun create(): List<TabBarInfo> {
            return mutableListOf(
                Gallery(),
                Favorite()
            )
        }
    }
}