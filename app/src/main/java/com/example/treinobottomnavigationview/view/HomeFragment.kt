package com.example.treinobottomnavigationview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.treinobottomnavigationview.R

class HomeFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home,container,false)

        val recycler_view = rootView.findViewById(R.id.recycle_view_movie) as RecyclerView
        val datas = Datas().items

        recycler_view.adapter = MovieAdapter(datas)
        // pega o contexto de activity
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.setHasFixedSize(true)

        return rootView
    }
}