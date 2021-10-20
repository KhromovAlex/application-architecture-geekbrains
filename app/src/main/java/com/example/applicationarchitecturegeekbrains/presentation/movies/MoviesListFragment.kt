package com.example.applicationarchitecturegeekbrains.presentation.movies

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.databinding.FragmentMoviesListBinding
import com.example.applicationarchitecturegeekbrains.presentation.abs.AbsFragment
import com.example.applicationarchitecturegeekbrains.presentation.model.MovieModel
import com.example.applicationarchitecturegeekbrains.presentation.movies.adapter.MoviesListAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MoviesListFragment : AbsFragment(R.layout.fragment_movies_list), MoviesListView,
    MoviesListAdapter.MovieClickListener {
    @Inject
    lateinit var moviesListPresenterFactory: MoviesListPresenterFactory

    private val presenter: MoviesListPresenter by moxyPresenter {
        moviesListPresenterFactory.create()
    }

    private val viewBinding: FragmentMoviesListBinding by viewBinding()
    private val moviesListAdapter: MoviesListAdapter = MoviesListAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.moviesList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = moviesListAdapter
        }
    }

    override fun showMovies(list: List<MovieModel>) {
        moviesListAdapter.submitList(moviesList = list)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun onClickMovie(movie: MovieModel) {
        presenter.displayMovie(movie = movie)
    }

    companion object {
        fun newInstance(): Fragment =
            MoviesListFragment()
    }

}
