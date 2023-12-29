package com.example.sunflower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunflower.tabBar.HomeTabBarFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeTabBarFragment())
                .commit()
        }
    }
}
