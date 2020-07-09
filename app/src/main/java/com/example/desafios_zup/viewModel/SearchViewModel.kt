package com.example.desafios_zup.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafios_zup.repository.Data
import com.example.desafios_zup.view.MoviesModel

class SearchViewModel : ViewModel() {
    private val mMoviesList = MutableLiveData<List<MoviesModel>>()
    val moviesList: LiveData<List<MoviesModel>> = mMoviesList
    fun loadSearchView() {
        mMoviesList.value = Data().items
    }
}