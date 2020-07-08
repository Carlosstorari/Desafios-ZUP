package com.example.desafios_zup.view.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafios_zup.R
import com.example.desafios_zup.view.MoviesModel
import kotlinx.android.synthetic.main.movie_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewSearchAdapter() :
    RecyclerView.Adapter<RecyclerViewSearchAdapter.MovieHolder>(), Filterable {

    var moviesFilterList: List<MoviesModel> = arrayListOf()

    lateinit var mcontext: Context

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val capa: ImageView = itemView.capa
        val nome: TextView = itemView.nome
        val genero: TextView = itemView.genero
        val pais: TextView = itemView.pais
        val sinopse: TextView = itemView.sinopse
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val moviesListView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        val sch = MovieHolder(moviesListView)
        mcontext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return moviesFilterList.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val currentItem = moviesFilterList[position]
        holder.capa.setImageResource(currentItem.imageResource)
        holder.nome.text = currentItem.nome
        holder.genero.text = currentItem.genero
        holder.pais.text = currentItem.pais
        holder.sinopse.text = currentItem.sinopse
    }

    private fun containsCharFilter(row: MoviesModel, charFilter: String): Boolean {
        return row.nome.toLowerCase(Locale.ROOT)
            .contains(charFilter.toLowerCase(Locale.ROOT))
    }

    fun filterList(charFilter: String): List<MoviesModel> {
        val resultList = ArrayList<MoviesModel>()
        for (row in moviesFilterList) {

            if (containsCharFilter(row, charFilter)) {
                resultList.add(row)
            }
        }
        return resultList
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isNotEmpty()) {
                    moviesFilterList = filterList(charSearch)
                }
                val filterResults = FilterResults()
                filterResults.values = moviesFilterList
                return filterResults
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                moviesFilterList = results?.values as List<MoviesModel>
                notifyDataSetChanged()
            }

        }
    }

    fun updateSearchView(list: List<MoviesModel>) {
        moviesFilterList = list
        notifyDataSetChanged()
    }

}