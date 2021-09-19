package com.example.dh.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val mFragmentList: ArrayList<Fragment> = arrayListOf()


    fun addFragment( fragment:Fragment) {
        mFragmentList.add(fragment);
    }


    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {
     return mFragmentList.get(position)
    }

}