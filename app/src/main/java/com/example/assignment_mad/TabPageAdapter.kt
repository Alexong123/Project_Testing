package com.example.assignment_mad

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabPageAdapter(activity: FragmentActivity,private val tabCount:Int):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int =tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position)
        {
            0->Home_Fragment()
            1->Search_Page_Fragment()
            2->Save_Job_Fragment()
            3->Notification_Fragment()
            4->UserFragment()
            else ->Home_Fragment()
        }
    }
}