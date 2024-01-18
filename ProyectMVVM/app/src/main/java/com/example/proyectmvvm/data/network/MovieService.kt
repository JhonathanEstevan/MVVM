package com.example.myapplicationmvvm.data.network

import com.example.myapplicationmvvm.core.RetrofitHelper
import com.example.myapplicationmvvm.data.model.Movie
import com.example.myapplicationmvvm.data.model.ResponseModel
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class MovieService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getMovies():ResponseModel?{

        return withContext(Dispatchers.IO){
            val response: Response<ResponseModel> = retrofit.create(MovieApiClient::class.java).getAllMovies()
            response.body()
        }
    }
}