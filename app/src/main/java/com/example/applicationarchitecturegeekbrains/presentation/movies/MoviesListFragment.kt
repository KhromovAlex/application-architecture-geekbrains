package com.example.applicationarchitecturegeekbrains.presentation.movies

import androidx.fragment.app.Fragment
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.presentation.abs.AbsFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MoviesListFragment : AbsFragment(R.layout.fragment_movies_list) {
    @Inject
    lateinit var moviesListPresenterFactory: MoviesListPresenterFactory

    private val presenter: MoviesListPresenter by moxyPresenter {
        moviesListPresenterFactory.create()
    }

    companion object {

        fun newInstance(): Fragment =
            MoviesListFragment()
    }
}
