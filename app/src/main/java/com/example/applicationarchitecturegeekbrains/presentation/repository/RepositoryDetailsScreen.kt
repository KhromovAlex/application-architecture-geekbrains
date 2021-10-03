package com.example.applicationarchitecturegeekbrains.presentation.repository

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class RepositoryDetailsScreen(private val countForks: Int) :
    FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        RepositoryDetailsFragment.newInstance(countForks)

}
