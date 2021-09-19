package com.example.dh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.dh.adapter.ViewPagerAdapter


import com.example.dh.ui.favorites.FavoritesFragment
import com.example.dh.ui.news.NewsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    val newsFragment = NewsFragment()
    val favsFragment = FavoritesFragment()
    private lateinit var viewPager: ViewPager
    private var prevMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(applicationContext)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        viewPager = findViewById(R.id.viewpager);


        bottomNavigation.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener() {
                when (it.itemId) {
                    R.id.news ->
                        viewPager.currentItem = 0
                    R.id.favs ->
                        viewPager.currentItem = 1
                }
                return@OnNavigationItemSelectedListener false
            })
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null) {
                    prevMenuItem?.setChecked(false);
                } else {
                    bottomNavigation.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigation.getMenu().getItem(position);
            }

        })
        setupViewPager(viewPager);

    }

    fun setupViewPager(viewPager: ViewPager) {
        val adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager);
        adapter.addFragment(newsFragment);
        adapter.addFragment(favsFragment);
        viewPager.setAdapter(adapter);
    }
}