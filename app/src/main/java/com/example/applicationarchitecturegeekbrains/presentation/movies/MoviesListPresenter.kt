package com.example.applicationarchitecturegeekbrains.presentation.movies

import com.example.applicationarchitecturegeekbrains.domain.repository.MovieRepository
import com.example.applicationarchitecturegeekbrains.presentation.model.MovieModel
import com.example.applicationarchitecturegeekbrains.presentation.movie.MovieDetailsScreen
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class MoviesListPresenter @AssistedInject constructor(
    private val movieRepository: MovieRepository,
    private val router: Router,
    private val schedulers: com.example.applicationarchitecturegeekbrains.scheduler.Schedulers,
) : MvpPresenter<MoviesListView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposable.add(
            movieRepository
                .getMovies()
                .map { movies -> movies.map(MovieModel.Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showMovies,
                    viewState::showError,
                )
        )

    }

    fun displayMovie(movie: MovieModel) = router.navigateTo(MovieDetailsScreen(movie.id))

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
