package com.example.applicationarchitecturegeekbrains.presentation.movie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MovieDetailsScreen(private val id: Int) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        MovieDetailsFragment.newInstance(id)

}
