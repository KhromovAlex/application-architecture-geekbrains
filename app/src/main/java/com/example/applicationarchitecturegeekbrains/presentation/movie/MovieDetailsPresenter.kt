package com.example.applicationarchitecturegeekbrains.presentation.movie

import com.example.applicationarchitecturegeekbrains.domain.repository.MovieRepository
import com.example.applicationarchitecturegeekbrains.presentation.model.MovieModel
import com.example.applicationarchitecturegeekbrains.scheduler.Schedulers
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class MovieDetailsPresenter @AssistedInject constructor(
    private val movieRepository: MovieRepository,
    private val schedulers: Schedulers,
    @Assisted private val id: Int
) : MvpPresenter<MovieDetailsView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposable.add(
            movieRepository
                .getMovieById(id)
                .map(MovieModel.Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showMovie,
                    viewState::showError,
                )
        )

    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}
