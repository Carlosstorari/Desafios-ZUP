package com.example.desafios_zup.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafios_zup.R
import com.example.desafios_zup.view.MoviesModel

class MovieAdapter() : RecyclerView.Adapter<MovieViewHolder>() {

    private var mMoviesList: List<MoviesModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun getItemCount() = mMoviesList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = mMoviesList[position]
        holder.capa.setImageResource(currentItem.imageResource)
        holder.nome.text = currentItem.nome
        holder.genero.text = currentItem.genero
        holder.pais.text = currentItem.pais
        holder.sinopse.text = currentItem.sinopse
    }


    fun updateHome(list: List<MoviesModel>) {
        mMoviesList = list
        notifyDataSetChanged()
    }
}