package com.example.applicationarchitecturegeekbrains.presentation.repositories

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class RepositoriesScreen(private val url: String) :
    FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        RepositoriesFragment.newInstance(url)

}
