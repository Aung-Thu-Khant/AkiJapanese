package com.japanese.aki.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.japanese.aki.onBoarding.OnBoardingFragment2
import com.japanese.aki.onBoarding.OnBoardingFragment3
import com.japanese.aki.onBoarding.onBoardingFragment1

class OnBoardingAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> onBoardingFragment1()
            1 -> OnBoardingFragment2()
            2 -> OnBoardingFragment3()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}