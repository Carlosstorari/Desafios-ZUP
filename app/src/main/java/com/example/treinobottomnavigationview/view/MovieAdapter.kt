package com.example.treinobottomnavigationview.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.treinobottomnavigationview.R
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val items: List<Movies>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = items[position]
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
}