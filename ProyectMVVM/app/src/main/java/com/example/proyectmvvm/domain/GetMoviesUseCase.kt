package com.example.myapplicationmvvm.domain

import com.example.myapplicationmvvm.data.MovieRepository
import com.example.myapplicationmvvm.data.model.Movie
import com.example.myapplicationmvvm.data.model.ResponseModel

class GetMoviesUseCase {

    private val repository = MovieRepository()

    suspend operator fun invoke():ResponseModel?{
        return repository.getAllMovies()
    }

    suspend fun getMoviesFilterSearch(filter:String):List<Movie>{
        var movies:List<Movie>? = repository.getAllMovies()?.movies
        val filteredMovies = movies?.filter { movie ->
            movie.original_title.contains(filter, ignoreCase = true)
        }

        return filteredMovies ?: emptyList()
    }
}