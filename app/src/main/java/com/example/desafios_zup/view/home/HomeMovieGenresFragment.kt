package com.example.desafios_zup.view.home

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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeMovieGenresFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val mAdapter: MovieAdapter =
        MovieAdapter()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val movieGenre = arguments?.getString("text") ?: ""
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        observer()
        homeViewModel.load(movieGenre)
        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler_view = recycle_view_movie
        recycler_view.adapter = mAdapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)
    }

    companion object {
        fun newInstance(s: String) =
            HomeMovieGenresFragment().apply {
                arguments = Bundle().apply {
                    putString("text", s)
                }
            }


    }

    private fun observer() {
        homeViewModel.moviesList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateHome(it)
        })
    }
}