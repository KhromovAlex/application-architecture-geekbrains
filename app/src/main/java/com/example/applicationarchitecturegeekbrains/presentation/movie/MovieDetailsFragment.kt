package com.example.applicationarchitecturegeekbrains.presentation.movie

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.presentation.abs.AbsFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MovieDetailsFragment : AbsFragment(R.layout.fragment_movie_details) {
    @Inject
    lateinit var movieDetailsPresenterFactory: MovieDetailsPresenterFactory

    private val presenter: MovieDetailsPresenter by moxyPresenter {
        movieDetailsPresenterFactory.create(id ?: 0)
    }

    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ARG_ID)
        }
    }

    companion object {
        private const val ARG_ID = "param id"

        fun newInstance(id: Int): Fragment =
            MovieDetailsFragment().apply {
                arguments = bundleOf(
                    ARG_ID to id
                )
            }
    }
}
