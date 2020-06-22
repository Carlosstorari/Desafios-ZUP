package com.example.desafios_zup.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafios_zup.R
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

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

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val capa: ImageView = itemView.capa
        val nome: TextView = itemView.nome
        val genero: TextView = itemView.genero
        val pais: TextView = itemView.pais
        val sinopse: TextView = itemView.sinopse
    }

    fun updateHome(list: List<MoviesModel>) {
        mMoviesList = list
        notifyDataSetChanged()
    }
}