package com.example.desafios_zup.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafios_zup.repository.Data
import com.example.desafios_zup.view.MoviesModel

class HomeViewModel : ViewModel() {
    private val mMoviesList = MutableLiveData<List<MoviesModel>>()
    val moviesList: LiveData<List<MoviesModel>> = mMoviesList

    private val mGenresList = MutableLiveData<List<String>>()
    val genresList: LiveData<List<String>> = mGenresList

    fun load(str : String) {
        if(str == "Todos"){
            mMoviesList.value = Data().items
        } else {
            mMoviesList.value = Data().items.filter { it.genero == str  }
        }
    }

    fun loadTopics() {
        mGenresList.value = Data().genresList
    }
}