package com.example.myapplicationmvvm.data.network

import com.example.myapplicationmvvm.data.model.Movie
import com.example.myapplicationmvvm.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.Response


interface MovieApiClient {
    @GET("b/bloc-car.appspot.com/o/movies.json?alt=media&token=b71f132b-f2cc-45c6-ba34-22b0a9d3a3a9")
    suspend fun getAllMovies(
     //   @Header("X-P2P-Access-Token") token: String
    ):Response<ResponseModel>

}