package com.example.desafios_zup.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.desafios_zup.R
import com.example.desafios_zup.repository.TabMenuOptions
import com.example.desafios_zup.viewModel.HomeViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val rootView = inflater.inflate(R.layout.main_home_fragment, container, false)

        val repository = TabMenuOptions().items

        val pager = rootView.findViewById(R.id.pager) as ViewPager2
        val tabs = rootView.findViewById(R.id.tabs) as TabLayout

        pager.adapter = ViewPagerFragmentAdapter(requireActivity())

//        observer()
//        homeViewModel.loadTopics()

        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = repository[position]
        }.attach()

        return rootView
    }
}