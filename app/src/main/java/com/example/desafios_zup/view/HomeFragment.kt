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
import com.example.desafios_zup.R
import com.example.desafios_zup.viewModel.HomeViewModel

class HomeFragment : Fragment(){

    private lateinit var homeViewModel: HomeViewModel
    private val mAdapter: MovieAdapter = MovieAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val rootView = inflater.inflate(R.layout.fragment_home,container,false)

        val recycler_view = rootView.findViewById(R.id.recycle_view_movie) as RecyclerView


        recycler_view.adapter = mAdapter
        // pega o contexto de activity
        recycler_view.layoutManager = LinearLayoutManager(context)

        recycler_view.setHasFixedSize(true)

        observer()
        homeViewModel.load()

        return rootView
    }

    private fun observer() {
        homeViewModel.moviesList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateHome(it)
        })
    }
}