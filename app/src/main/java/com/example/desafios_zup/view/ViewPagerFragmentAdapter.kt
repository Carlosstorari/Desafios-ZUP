package com.example.desafios_zup.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.desafios_zup.repository.TabMenuOptions

class ViewPagerFragmentAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        val repository = TabMenuOptions().items
        //private var mGenresList: List<String> = arrayListOf()
        override fun getItemCount(): Int = repository.size

        override fun createFragment(position: Int): Fragment = HomeMovieGenresFragment.newInstance(repository[position])

//        fun updateViewPager(list: List<String>){
//                mGenresList = list
//                notifyDataSetChanged()
//        }
}