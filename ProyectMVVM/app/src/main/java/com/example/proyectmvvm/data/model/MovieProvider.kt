package com.example.myapplicationmvvm.data.model

class MovieProvider {
    companion object {
        var movies: List<Movie> = emptyList()
        var moviesTemp: List<Movie> = emptyList()
    }
}