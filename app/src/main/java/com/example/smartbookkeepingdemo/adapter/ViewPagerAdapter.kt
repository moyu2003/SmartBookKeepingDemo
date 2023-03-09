package com.example.smartbookkeepingdemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(private val fm: FragmentManager, private val fragmentList: ArrayList<Fragment>): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

//    override fun getPageTitle(position: Int): CharSequence? {
//        return super.getPageTitle(position)
//    }
}