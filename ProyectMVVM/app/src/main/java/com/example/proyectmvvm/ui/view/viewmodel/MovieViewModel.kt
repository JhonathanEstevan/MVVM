package com.example.myapplicationmvvm.ui.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationmvvm.data.model.Movie
import com.example.myapplicationmvvm.data.model.ResponseModel
import com.example.myapplicationmvvm.domain.GetMoviesUseCase
import kotlinx.coroutines.launch

class MovieViewModel:ViewModel() {

    val movieModel = MutableLiveData<Movie>()
    val isLoading = MutableLiveData<Boolean>()
    var getMoviesUseCase = GetMoviesUseCase()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: ResponseModel? = getMoviesUseCase()
            if(!result?.movies.isNullOrEmpty()){
               // movieModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun filterSearch(title:String){
        viewModelScope.launch {
           // getMoviesUseCase.getMoviesFilterSearch(title)
        }

    }




}