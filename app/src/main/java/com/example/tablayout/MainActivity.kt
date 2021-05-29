package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.tablayout.adapter.ViewPagerAdapter
import com.example.tablayout.fragment.FavoriteFragment
import com.example.tablayout.fragment.HomeFragment
import com.example.tablayout.fragment.SettingsFragment
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var adapter: ViewPagerAdapter
    lateinit var tab: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tab)

        setAdapter()

    }
    private fun setAdapter(){
        adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(FavoriteFragment(), "Favorite")
        adapter.addFragment(SettingsFragment(), "Settings")

        viewPager.adapter = adapter
        tab.setupWithViewPager(viewPager)
        tab.getTabAt(0)?.setIcon(R.drawable.home)
        tab.getTabAt(1)?.setIcon(R.drawable.favorite)
        tab.getTabAt(2)?.setIcon(R.drawable.settings)
    }

}