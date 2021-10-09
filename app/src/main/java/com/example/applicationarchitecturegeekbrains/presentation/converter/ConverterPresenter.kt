package com.example.applicationarchitecturegeekbrains.presentation.converter

import android.net.Uri
import android.view.View
import com.example.applicationarchitecturegeekbrains.data.ConverterRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class ConverterPresenter(
    private val repository: ConverterRepository,
) : MvpPresenter<ConverterView>() {
    private val disposable = CompositeDisposable()

    fun selectImage(view: View) {
        viewState.pickImage()
    }

    fun convertImage(uri: Uri?, scheduler: Scheduler) {
        disposable.add(
            repository.convert(uri)
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    viewState::showSuccess,
                    viewState::showError,
                )
        )
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}
