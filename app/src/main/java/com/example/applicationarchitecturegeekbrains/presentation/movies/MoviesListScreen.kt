package com.example.applicationarchitecturegeekbrains.presentation.movies

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MoviesListScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        MoviesListFragment.newInstance()

}
