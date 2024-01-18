package com.example.proyectmvvm.ui.view.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplicationmvvm.ui.view.viewmodel.MovieViewModel

import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationmvvm.data.model.MovieProvider
import com.example.proyectmvvm.R
import com.example.proyectmvvm.databinding.ActivityMainBinding
import com.example.proyectmvvm.ui.view.adapter.MoviesAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
        //initRecycler()
    }

    private fun setupNavigation(){
        val bottomNavigationView = binding.bottomNavigationView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment.navController
        )
    }

    private fun initRecycler(){
      //  binding.recyclerMovies.layoutManager = LinearLayoutManager(this)
      //  binding.recyclerMovies.adapter = MoviesAdapter(MovieProvider.movies)
    }
}