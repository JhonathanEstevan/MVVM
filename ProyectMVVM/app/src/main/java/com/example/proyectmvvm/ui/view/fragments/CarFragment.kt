package com.example.proyectmvvm.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectmvvm.R
import com.example.proyectmvvm.databinding.FragmentCarBinding
import com.example.proyectmvvm.databinding.FragmentFavoriteBinding
import com.example.proyectmvvm.databinding.FragmentHomeBinding

class CarFragment : Fragment() {

    private lateinit var binding: FragmentCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentCarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return binding.root
    }


}