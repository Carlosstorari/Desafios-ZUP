package com.example.desafios_zup.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafios_zup.repository.Data
import com.example.desafios_zup.view.MoviesModel

class HomeViewModel : ViewModel() {
    private val mMoviesList = MutableLiveData<List<MoviesModel>>()
    val moviesList: LiveData<List<MoviesModel>> = mMoviesList

    fun load() {
        mMoviesList.value = Data().items
    }
}