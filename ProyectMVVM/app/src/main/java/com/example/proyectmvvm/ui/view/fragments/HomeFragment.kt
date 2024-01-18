package com.example.proyectmvvm.ui.view.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.proyectmvvm.R
import com.example.proyectmvvm.databinding.FragmentHomeBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationmvvm.data.model.Movie
import com.example.myapplicationmvvm.data.model.MovieProvider
import com.example.myapplicationmvvm.ui.view.viewmodel.MovieViewModel
import com.example.proyectmvvm.ui.view.adapter.MoviesAdapter
import android.text.TextWatcher


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val movieViewModel: MovieViewModel by viewModels()

    var movieList: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val appContext = requireContext().applicationContext

        movieViewModel.onCreate()
        movieViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            //id del progress
            if(!it){
                MovieProvider.moviesTemp = MovieProvider.movies
                initRecycler(appContext)
            }
        })

        binding.editTextSearch.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Este método se llama para notificar que algo está a punto de cambiar en el texto.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Este método se llama para notificar que el texto ha cambiado.
            }

            override fun afterTextChanged(s: Editable?) {
                // Este método se llama para notificar que el cambio de texto ha finalizado.
                val text = s.toString()
                // Hacer algo con el texto, por ejemplo, llamar a una función de filtrado.
                println("Busqueda...${text}")

                if(text == ""){
                    MovieProvider.moviesTemp = MovieProvider.movies
                }else{
                    val filteredMovies:List<Movie> = MovieProvider.movies.filter { movie ->
                        movie.original_title.contains(text, ignoreCase = true)
                    } ?: emptyList()

                    if(filteredMovies.isNotEmpty()){
                        MovieProvider.moviesTemp = filteredMovies
                    }
                }


               initRecycler(appContext)
              //  filterMovies(text)
            }
        })
        return binding.root
    }

    private fun initRecycler(context: Context) {
        binding.recyclerMovies.layoutManager = LinearLayoutManager(context)
        binding.recyclerMovies.adapter = MoviesAdapter(MovieProvider.moviesTemp) { movie ->
            addToFavorite(
                movie
            )
        }
    }

    fun addToFavorite(movie:Movie){
        //add to db favorite
    }
}
