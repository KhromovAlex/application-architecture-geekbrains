package com.example.applicationarchitecturegeekbrains.presentation

import android.os.Bundle
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.presentation.abs.AbsActivity
import com.example.applicationarchitecturegeekbrains.presentation.movies.MoviesListScreen
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(MoviesListScreen())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}
