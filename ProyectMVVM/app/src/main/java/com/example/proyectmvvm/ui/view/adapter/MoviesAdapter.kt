package com.example.proyectmvvm.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationmvvm.data.model.Movie
import com.example.proyectmvvm.R

class MoviesAdapter(private val moviesList:List<Movie>,private val onClickFavorite:(Movie)->Unit):RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie,parent,false))
    }

    override fun getItemCount(): Int  =  moviesList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = moviesList[position]
        holder.render(item,onClickFavorite)
    }

}