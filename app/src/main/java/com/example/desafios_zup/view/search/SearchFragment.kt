package com.example.desafios_zup.view.search

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafios_zup.R
import com.example.desafios_zup.viewModel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {
    private lateinit var searchViewModel: SearchViewModel
    val mAdapter: RecyclerViewSearchAdapter = RecyclerViewSearchAdapter()
    lateinit var recyclerViewMovies: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        val rootView = inflater.inflate(R.layout.fragment_search, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupSearchView(search_view_movies)
        recyclerViewMovies = recycler_view_movie
        recyclerViewMovies.layoutManager = LinearLayoutManager(context)
        recyclerViewMovies.setHasFixedSize(true)
        recyclerViewMovies.adapter = mAdapter
    }

    private fun setupSearchView(view: View): View {
        val searchIcon = view.findViewById(R.id.search_mag_icon) as ImageView
        searchIcon.setColorFilter(Color.WHITE)
        val cancelIcon = view.findViewById(R.id.search_close_btn) as ImageView
        cancelIcon.setColorFilter(Color.WHITE)
        val textView = view.findViewById(R.id.search_src_text) as TextView
        textView.setTextColor(Color.WHITE)
        val movie_search =
            view.findViewById(R.id.search_view_movies) as androidx.appcompat.widget.SearchView
        movie_search.setOnQueryTextListener(movieSearch())
        return view
    }

    private fun movieSearch(): androidx.appcompat.widget.SearchView.OnQueryTextListener {
        return object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                observer()
                searchViewModel.loadSearchView()
                mAdapter.filter.filter(newText)
                val isTextValid = newText != null && newText.isNotEmpty()
                if (isTextValid) {
                    recyclerViewMovies.visibility = View.VISIBLE
                } else {
                    recyclerViewMovies.visibility = View.GONE
                }
                return false
            }
        }
    }

    private fun observer() {
        searchViewModel.moviesList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateSearchView(it)
        })
    }
}
