package com.example.applicationarchitecturegeekbrains.presentation.movie

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.presentation.abs.AbsFragment
import com.example.applicationarchitecturegeekbrains.presentation.model.MovieModel
import moxy.ktx.moxyPresenter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MovieDetailsFragment : AbsFragment(R.layout.fragment_movie_details), MovieDetailsView {
    @Inject
    lateinit var movieDetailsPresenterFactory: MovieDetailsPresenterFactory

    private val presenter: MovieDetailsPresenter by moxyPresenter {
        movieDetailsPresenterFactory.create(id ?: 0)
    }

    private var id: Int? = null

    private val poster: ImageView by lazy { requireActivity().findViewById(R.id.poster) }
    private val title: TextView by lazy { requireActivity().findViewById(R.id.title) }
    private val overview: TextView by lazy { requireActivity().findViewById(R.id.overview) }
    private val date: TextView by lazy { requireActivity().findViewById(R.id.date) }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            id = it.getInt(ARG_ID)
        }
        super.onCreate(savedInstanceState)

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

    override fun showMovie(movie: MovieModel) {
        title.text = movie.originalTitle
        overview.text = movie.overview
        date.text = if (movie.releaseDate != null) SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(movie.releaseDate) else ""

        Glide.with(requireContext())
            .load(movie.posterPath)
            .error(R.drawable.ic_baseline_image_not_supported_24)
            .into(poster)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }
}
