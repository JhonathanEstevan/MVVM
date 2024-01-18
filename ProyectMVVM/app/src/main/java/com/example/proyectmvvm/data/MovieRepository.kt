package com.example.myapplicationmvvm.data

import com.example.myapplicationmvvm.data.model.MovieProvider
import com.example.myapplicationmvvm.data.model.ResponseModel
import com.example.myapplicationmvvm.data.network.MovieService

class MovieRepository {

    private val api = MovieService()

    suspend fun getAllMovies():ResponseModel?{
        val response: ResponseModel? = api.getMovies()
        MovieProvider.movies = response?.movies ?: emptyList()
        return response
    }
}