package com.example.desafios_zup.view.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val capa: ImageView = itemView.capa
    val nome: TextView = itemView.nome
    val genero: TextView = itemView.genero
    val pais: TextView = itemView.pais
    val sinopse: TextView = itemView.sinopse
}