package com.example.proyectmvvm.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationmvvm.data.model.Movie
import com.example.proyectmvvm.databinding.ItemMovieBinding

class MovieViewHolder(view:View) : RecyclerView.ViewHolder(view){

    val binding = ItemMovieBinding.bind(view)

    fun render(movie:Movie,onClickFavorite:(Movie)->Unit){
        binding.txtNameMovie.text = movie.original_title
        Glide.with( binding.imgMovie).load(movie.backdrop_path).into( binding.imgMovie)
        itemView.setOnClickListener{onClickFavorite(movie)}
       // binding.buttonFavorite.setOnClickListener()
    }

}